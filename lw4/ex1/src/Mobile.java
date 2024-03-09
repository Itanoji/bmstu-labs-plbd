public class Mobile {
    private Model model;

    public Mobile(String name, long ram, String cpu, long memory) {
        this.model = new Model(name, ram, cpu, memory);
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public class Model {
        private String name;
        private long ram;
        private String cpu;
        private long memory;

        public Model(String name, long ram, String cpu, long memory) {
            this.name = name;
            this.ram = ram;
            this.cpu = cpu;
            this.memory = memory;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getRam() {
            return ram;
        }

        public void setRam(long ram) {
            this.ram = ram;
        }

        public String getCpu() {
            return cpu;
        }

        public void setCpu(String cpu) {
            this.cpu = cpu;
        }

        public long getMemory() {
            return memory;
        }

        public void setMemory(long memory) {
            this.memory = memory;
        }
    }
}
