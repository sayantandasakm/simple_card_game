package src.com.company;

public enum CardNumber {
    A{
        public int getValue(){
            return 1;
        }

        public int getFaceOffValue(){
            return 14;
        }
    },
    K{
        public int getValue(){
            return 13;
        }

        public int getFaceOffValue(){
            return getValue();
        }
    },
    Q{
        public int getValue(){
            return 12;
        }

        public int getFaceOffValue(){
            return getValue();
        }
    },
    J{
        public int getValue(){
            return 11;
        }

        public int getFaceOffValue(){
            return getValue();
        }
    },
    _2{
        public int getValue(){
            return 2;
        }

        public int getFaceOffValue(){
            return getValue();
        }
    },
    _3{
        public int getValue(){
            return 3;
        }

        public int getFaceOffValue(){
            return getValue();
        }
    },
    _4{
        public int getValue(){
            return 4;
        }

        public int getFaceOffValue(){
            return getValue();
        }
    },
    _5{
        public int getValue(){
            return 5;
        }

        public int getFaceOffValue(){
            return getValue();
        }
    },
    _6{
        public int getValue(){
            return 6;
        }

        public int getFaceOffValue(){
            return getValue();
        }
    },
    _7{
        public int getValue(){
            return 7;
        }

        public int getFaceOffValue(){
            return getValue();
        }
    },
    _8{
        public int getValue(){
            return 8;
        }

        public int getFaceOffValue(){
            return getValue();
        }
    },
    _9{
        public int getValue(){
            return 9;
        }

        public int getFaceOffValue(){
            return getValue();
        }
    },
    _10{
        public int getValue(){
            return 10;
        }

        public int getFaceOffValue(){
            return getValue();
        }
    };

    public int getValue(){
        return 0;
    }

    public int getFaceOffValue(){
        return 0;
    }
}
