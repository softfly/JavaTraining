package training.java6.oca;

public class EnumTraining {

    protected static String FORMAT_OUT = "%-25s %-25s\n";

    enum Season {
        WINTER(1) {
            public boolean cold() {
                return false;
            }
        },
        SPRING(2) {
            /* this is a constant-specific class body*/ },
        SUMMER(3), FALL(4) {
            public boolean cold() {
                return false;
            }
        };
        int i;

        private Season(int i) {
            this.i = i;
        }

        public boolean cold() {
            return false;
        }
    }

    public static void main(String[] args) {
        Enum<?> e = Season.WINTER;
        print(e);
        for (Enum<?> n : Season.values()) {
            print("values:", n);
        }
    }

    protected static void print(Enum<?> e) {
        print("name:", e.name());
        print("ordinal:", e.ordinal());
        print("getDeclaringClass:", e.getDeclaringClass());
        print("getClass:", e.getClass());
        print("valueOf:", Enum.valueOf(e.getDeclaringClass(), "WINTER"));
    }

    protected static void print(Object v1, Object v2) {
        System.out.format(FORMAT_OUT, v1, v2);
    }

}