import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;

public class Main {
    public static void main(String[] args) {

        SparkSession spark = SparkSession.builder()
                .appName("Video Game Sales")
                .master("local[*]")
                .getOrCreate();

        spark.sparkContext().setLogLevel("ERROR");

        Dataset<Row> dataset = spark.read().format("csv")
                .option("header", "true")
                .load("vgsales.csv");
        dataset.createOrReplaceTempView("game_sales");

        // 1 Выводим все
        System.out.println("Весь датасет:");
        spark.sql("select * from game_sales").show();

        // 2 Выводим топ5 самых продаваемых игр за всё время
        System.out.println("Топ5 самых продаваемых игр за всё время:");
        spark.sql("SELECT * FROM game_sales ORDER BY Global_Sales DESC LIMIT 5").show();

        // 3 Выводим самые продаваемые игры в японии
        System.out.println("5 самых продаваемых игр в японии");
        spark.sql("SELECT * FROM game_sales ORDER BY JP_Sales DESC LIMIT 5").show();

        //4 5 самых продаваемых игр в японии жанра Action
        System.out.println("3 самых продаваемых игр в японии жанра Action");
        spark.sql("SELECT * FROM game_sales WHERE Genre = 'Action' ORDER BY JP_Sales DESC LIMIT 3").show();

        // 5 Вывести игры сони, сортируя по глобальным продажамм
        System.out.println("Игры компании Sony Computer Entertainment");
        spark.sql("SELECT * FROM game_sales WHERE Publisher = 'Sony Computer Entertainment' ORDER BY Global_Sales DESC").show();

        // 6 Самые продаваемые игры выпущенные в 2017
        System.out.println("Самые популярные игры в 2017");
        spark.sql("SELECT * FROM game_sales WHERE Year = '2017' ORDER BY Global_Sales DESC LIMIT 5").show();

        // 7 Самые продаваемые игры выпущенные на PS4
        System.out.println("Самые продаваемые игры выпущенные на PS4");
        spark.sql("SELECT * FROM game_sales WHERE Platform = 'PS4' ORDER BY Global_Sales DESC LIMIT 5").show();

        // 8 Самые продаваемые игры выпущенные на PS4
        System.out.println("Самые непродаваемые игры выпущенные на PS4 в 2014 году");
        spark.sql("SELECT * FROM game_sales WHERE Platform = 'PS4' and Year = '2014' ORDER BY Global_Sales LIMIT 5").show();

        // 9 Продажи игр серии Yakuza
        System.out.println("Продажа игр серии Yakuza");
        spark.sql("SELECT * FROM game_sales WHERE Name LIKE 'Yakuza%'").show();

        // 10 Самые популярные игры Square Enix
        System.out.println("5 покупаемых игр Square Enix");
        spark.sql("SELECT * FROM game_sales WHERE Publisher = 'Square Enix' ORDER BY Global_Sales DESC LIMIT 10").show();


        spark.stop();
    }
}