1 public class VMachine {
2   private static int[] registers = new int[16];
3   private static int flag = 0;
4   private static int pc = 0;
5   private static int[] instructions;
6　
7   public static final byte NOP = 0;
8   public static final byte LOAD = 1;
9   public static final byte ADD = 2;
10  public static final byte JUMP = 6;
11  public static final byte COMP = 7;
12  public static final byte RTN = 8;
13  public static final byte DUMP = 9;
14　
15  public static final byte EQ = 0;
16  public static final byte LT = 1;
17  public static final byte GT = 2;
18  public static final byte NA = 3;
19　
20　    private static int getInstruction() {
21　        return instructions[pc++];
22　    }
23　    private static int getOPcode( int instruction ) { 
24　        byte op = (byte)(instruction >> 24);
25　        return op;
26　    }
27　
28　    private static int getCondition( int instruction ) {
29　        return ((instruction >> 16) & 0xff);
30　    }
31　    private static int getFirstOperand( int instruction ) {
32　        return ((instruction >> 16) & 0xff);
33　    }
34　    private static int getSecondOperand( int instruction ) {
35　        short opr = (short)(instruction & 0xffff);
36　        return opr;
37　    }
38　
39　    private static int getFirstRegister( int instruction ) {
40　        return (getFirstOperand(instruction) & 0xf);
41　    }
42　
43　    private static int getSecondRegister( int instruction ) {
44　        return (getSecondOperand(instruction) & 0x0f);
45　    }
46　
47　    private static void add(int instruction) {
48　        registers[getFirstRegister(instruction)] 
49　            += registers[getSecondRegister(instruction)];
50　    }
51　    private static void comp(int instruction) {
52　        int reg = registers[getFirstRegister(instruction)];
53　        reg -= registers[getSecondRegister(instruction)];
54　        if( reg == 0 ) flag = EQ;
55　        else if( reg < 0 ) flag = LT;
56　        else flag = GT;
57　    }
58　    private static void dump(int instruction) {
59　        for(int i = 0 ; i < 16 ; ++i ) {
60　            System.out.print(registers[i] + " ");
61　        }
62　        System.out.print("\n");
63　    }
64　
65　    private static void jump(int instruction) {
66　            int offset = getSecondOperand(instruction);
67　            int cond = getCondition(instruction);
68　            if ( cond == NA || cond == flag ) pc += offset;
69　    }
70　
71　    private static void load(int instruction) {
72　        registers[getFirstRegister(instruction)]
73　            = getSecondOperand(instruction);
74　    }
75　
76　    private static void evaluate(int[] code,int start) {
77　        int instr;
78　        int op;
79　
80　        instructions = code;
81　        pc = start;
82　        for( ; ; ) {
83　            instr = getInstruction();
84　            op = getOPcode(instr);
85　            switch( op ) {
86　                case NOP : break;
87　                case LOAD :load(instr); break;
88　                case ADD : add(instr); break;
89　                case JUMP : jump(instr); break;
90　                case COMP : comp(instr); break;
91　                case RTN : return;
92　                case DUMP : dump(instr); break;
93　                default : throw new RuntimeException("Illegal");
94　            }
95　        }
96　    }
97　
98　    public static void main(String[] args) {
99　        int[] test_code = {
100　            (LOAD << 24) + (1 << 16) + 1,
101　            (LOAD << 24) + (2 << 16) + 3,
102　            (LOAD << 24) + (3 << 16) + 15,
103　            (ADD << 24) + (2 << 16) + 1,
104　            (DUMP << 24),
105　            (COMP << 24) + (2 << 16) + 3,
106　            (JUMP << 24) + (LT << 16) + ((-4) & 0xffff),
107　            (RTN << 24)
108　        };
109　        System.out.println("###### START ######");
110　        evaluate(test_code,0);
111　        System.out.println("###### DONE ! ######");
112　    }
113 }