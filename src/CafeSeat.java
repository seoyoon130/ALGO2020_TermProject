import java.lang.Math;

/**
 * 각 좌석에 대한 정보
 */
public class CafeSeat {
    private int sum = 0;
    private int number; // 좌석 번호
    private int pNum;
    private boolean outlet; // 콘센트 있는지 없는지
    private boolean lowTable;  // 테이블 높은지 낮은지
    private boolean window; // 창가 자리인지 아닌지
    private boolean sofa;   // 쇼파 자리인지 아닌지
    private boolean wall;   // 벽 좌석인지 아닌지
    // entrance
    private boolean entrance;   // 현관 위치
    private boolean toilet;     // 화장실 위치
    private boolean speaker;    // 스피커 위치
    private boolean counter;    // 카운터 위치

    public CafeSeat(){
        number = 0;
        pNum = -1;
        outlet = false;
        lowTable = false;
        window = false;
        sofa = false;
        wall = false;

        entrance =false;
        toilet = false;
        speaker = false;
        counter = false;
        sum = 0;
    }

    // mutator
    public void ispNum(int x){ pNum = x; }
    public void weighting(int num){ sum += num; }
    public void numbering(int num) { number = num;}

    public void isEntrance(){ entrance = true; }
    public void isToilet(){ toilet = true; }
    public void isSpeaker(){ speaker = true; }
    public void isCounter(){ counter = true;}

    public void isOutlet(){ outlet = true; }
    public void isLowTable(){outlet = true; }
    public void isWindow(){ window = true; }
    public void isSofa(){sofa = true; }
    public void isWall(){wall = true; }

    // getter
    public int getpNum() { return pNum;}
    public int getSum(){return sum;}
    public int getNumber(){return number;}
    public boolean getEntrance(){ return entrance; }
    public boolean getToilet(){ return toilet; }
    public boolean getSpeaker(){ return speaker; }

    public boolean getOutlet(){ return outlet; }
    public boolean getLowTable(){ return lowTable; }
    public boolean getWindow(){ return window; }
    public boolean getSofa (){ return sofa;}
    public boolean getWall(){ return wall; }
    public boolean getCounter(){ return counter; }

}

class Cafe{
    private static final int MAX = 1000;
    private static final int MAXIMUM = 100; // 최대 카페 면적

    public CafeSeat [][]area;   // 카페 면적

    public Cafe(int x, int y){  // row, col
        area = new CafeSeat[x][y];

        for(int i =0; i < area.length;i++){ // row
            for(int k = 0; k < area[i].length; k++){    // col
                area[i][k] = new CafeSeat();
            }
        }
    }
    public void setNumber(int x, int y, int num) {area[x][y].numbering(num);}
    public void setpNum(int x, int y, int num){ area[x][y].ispNum(num); }
    public void setEntrance(int x, int y){ area[x][y].isEntrance(); }
    public void setToilet(int x, int y){ area[x][y].isToilet(); }
    public void setSpeaker(int x, int y){ area[x][y].isSpeaker(); }
    public void setCounter(int x, int y){area[x][y].isCounter();}
    public void setOutlet(int x, int y){ area[x][y].isOutlet(); }
    public void setLowTable(int x, int y){ area[x][y].isLowTable(); }
    public void setWindow(int x, int y){ area[x][y].isWindow(); }
    public void setSofa(int x, int y){ area[x][y].isSofa(); }
    public void setWall(int x, int y){ area[x][y].isWall(); }
    /**
     * 현 좌표에서 현관까지 거리를 계산, 거리가 멀 수록 조용하기에 구한 거리만큼 가중치에 더하기 위함.
     * @param iX
     * @param iY
     * @return 현관까지 거리
     */
    private double farFromEntrance(int iX, int iY) {
        int[][] Enter = new int[2][2];  // 현관 2개일 수 있음
        int p = -1;
        double distance = 99999;
        for (int x = 0; x < area.length; x++) {   // 현관 위치 저장
            for (int y = 0; y < area[x].length; y++) {
                if (area[x][y].getEntrance()) {
                    p++;
                    Enter[p][0] = x; Enter[p][1] = y;
                }
            }
        }
        for (int k = 0; k <= p; k++) {  // 현관까지 거리 계산
            {
                if (Math.sqrt(Math.pow(Enter[p][0] - iX, 2) + Math.pow(Enter[p][1] - iY, 2)) < distance)
                    distance = Math.sqrt(Math.pow(Enter[p][0] - iX, 2) + Math.pow(Enter[p][1] - iY, 2));
            }
        }
        return distance;
    }
    /**
     * 현 좌표에서 카운터까지 거리를 계산, 거리가 멀 수록 조용하기에 구한 거리만큼 가중치에 더하기 위함.
     * @param iX
     * @param iY
     * @return 카운터까지 거리
     */
    private double farFromCounter(int iX, int iY) {
        int[][] desk = new int[6][6];  // 카운터 최대 크기 6
        int p = -1;
        double distance = 99999;
        for (int x = 0; x < area.length; x++) {   // 카운터 위치 저장
            for (int y = 0; y < area[x].length; y++) {
                if (area[x][y].getCounter()) {
                    p++;
                    desk[p][0] = x; desk[p][1] = y;
                }
            }
        }
        for (int k = 0; k <= p; k++) {  // 카운터까지 최단 거리 계산
            {
                if (Math.sqrt(Math.pow(desk[p][0] - iX, 2) + Math.pow(desk[p][1] - iY, 2)) < distance)
                    distance = Math.sqrt(Math.pow(desk[p][0] - iX, 2) + Math.pow(desk[p][1] - iY, 2));
            }
        }
        return distance;
    }
    /**
     * 현 좌표에서 화장실까지 거리를 계산, 거리가 멀 수록 조용하기에 구한 거리만큼 가중치에 더하기 위함.
     * @param iX
     * @param iY
     * @return 화장실까지 거리
     */
    private double farFromToliet(int iX, int iY) {
        int [] toliet = new int[2];

        double distance = 0;
        for (int x = 0; x < area.length; x++) {   // 화장실 위치 저장
            for (int y = 0; y < area[x].length; y++) {
                if (area[x][y].getToilet()) {
                    toliet[0] = x; toliet[1] = y;
                }
            }
        }
        distance = Math.sqrt(Math.pow(toliet[0] - iX, 2) + Math.pow(toliet[1] - iY, 2));
        return distance;
    }
    public String findOptimizesSeat(){
        int []max = new int[100];
        int []iX = new int[100];
        int []iY = new int[100];
        max[0] = -1000; iX[0]=0; iY[0]=0;
        int index = 0;
        for(int x = 0; x < area.length; x++){
            for(int y = 0; y < area[x].length; y++){
                if(area[x][y].getNumber() > 0){
                    System.out.println("\tmax = " + max[index] +", sum = " + area[x][y].getSum() + ", getNumber = " + area[x][y].getNumber());
                    if( area[x][y].getSum() > max[index]) {
                        for(int i = 0; i <=index; i++){ max[i] = -1; iX[i] = 0; iY[i] = 0; }
                        index = 0;
                        max[index] = area[x][y].getSum(); iX[index] = x; iY[index] = y;
                    }
                    else if (area[x][y].getSum() == max[index]){    // 중복 허용 처리
                        index++;
                        max[index] = area[x][y].getSum(); iX[index] = x; iY[index] = y;
                    }
                }
            }
        }
        String theSeats = "";
        for(int i = 0; i <= index; i++){
            theSeats += area[iX[i]][iY[i]].getNumber() + " ";
        }
        System.out.println(theSeats);
        return theSeats;
    }
    /* 공부 하기 좋은 좌석 */
    public String forStudy(){
        for(int x =0; x < area.length; x++){ // row
            for(int y = 0; y < area[x].length; y++){    // col
                if(area[x][y].getNumber() > 0){
                    if(area[x][y].getpNum() == 4) { area[x][y].weighting(250);} // 4인 좌석 + 350
                    if(area[x][y].getpNum() == 2) { area[x][y].weighting(200); }    // 2인 좌석 + 300
                    if(area[x][y].getOutlet()){ area[x][y].weighting(500);} // 콘센트있는 좌석에 + 500
                    if(!area[x][y].getEntrance()) {area[x][y].weighting((int)farFromEntrance(x, y) * 8);}   // + 현관까지 거리 * 8
                    if(!area[x][y].getLowTable()) {area[x][y].weighting(100);}  // 테이블 높이가 높으면 + 100
                    if(!area[x][y].getSofa()){ area[x][y].weighting(110);}  // 소파 자리가 아니면 + 110
                    if(!area[x][y].getWindow()){ area[x][y].weighting(100);}    // 창가 좌석이 아니면 + 100
                    if(!area[x][y].getToilet()) {area[x][y].weighting((int)farFromToliet(x,y) * 10);}    // + 화장실까지 거리 * 10
                    if (!area[x][y].getCounter()) {area[x][y].weighting((int)farFromCounter(x,y) * 9); }    // + 카운터까지 거리 * 9
                     // 모퉁이
                }
            }
        }
        return findOptimizesSeat();
    }
    /* 사진 찍기 좋은 좌석 */
    public String forPhoto(){
        for(int x = 0; x < area.length; x++){   // row
            for(int y = 0; y < area[x].length; y++){    // col
                if(area[x][y].getWindow()){ area[x][y].weighting((200) * (int)farFromToliet(x,y));} // (창가자리 + 200) * 화장실까지 거리
                if(area[x][y].getLowTable()) {
                    area[x][y].weighting(300);
                    if(area[x][y].getpNum() == 2) {area[x][y].weighting(200);}  // 2인 좌석 + 200
                }   // 낮은 좌석 + 300
                if(area[x][y].getWall()){ area[x][y].weighting(100);}   // 벽좌석(인테리어) + 500
                if(area[x][y].getpNum() == 1) { area[x][y].weighting(80);}  // 1인 좌석 + 80
                if(!area[x][y].getCounter()) { area[x][y].weighting((int)farFromCounter(x,y)); }   // + 카운터까지 거리
            }
        }
        return findOptimizesSeat();
    }
    /* 책 읽기 좋은 좌석 */
    public String forRead(){
        for(int x =0; x < area.length; x++){ // row
            for(int y = 0; y < area[x].length; y++){    // col
                if(area[x][y].getNumber() > 0){
                    if(area[x][y].getpNum() == 2) { area[x][y].weighting(50);}  // 2인 좌석 + 50
                    if(area[x][y].getpNum() == 1) { area[x][y].weighting(40);}  // 1인 좌석 + 40
                    if(area[x][y].getWindow()){ area[x][y].weighting(10);} // 창가 좌석 + 10
                    if(!area[x][y].getEntrance()) {area[x][y].weighting((int)farFromEntrance(x, y) * 9);}   // + 현관까지 거리 * 9
                    if(area[x][y].getLowTable()) {area[x][y].weighting(30);}  // 테이블 높이가 낮음 + 30
                    if(!area[x][y].getToilet()) {area[x][y].weighting((int)farFromToliet(x,y) * 8);}    // + 화장실까지 거리 * 88
                    if (!area[x][y].getCounter()) {area[x][y].weighting((int)farFromCounter(x,y) * 10);}    // + 카운터까지 거리 * 10
                    // 모퉁이
                }
            }
        }
        return findOptimizesSeat();
    }
    /* 미팅하기 좋은 좌석 */
    public String forMeet(){
        for(int x =0; x < area.length; x++){ // row
            for(int y = 0; y < area[x].length; y++){    // col
                if(area[x][y].getNumber() > 0){
                    if(area[x][y].getpNum() == 4) {area[x][y].weighting(400);} // 4인 좌석 + 300
                    if(!area[x][y].getEntrance()) {area[x][y].weighting((int)farFromEntrance(x, y) * 8);}   // + 현관까지 거리 * 8
                    if(!area[x][y].getLowTable()) {area[x][y].weighting(150);}  // 테이블 높이가 높으면 + 150
                    if(!area[x][y].getToilet()) {area[x][y].weighting((int)farFromToliet(x,y) * 9);}    // + 화장실까지 거리 * 9
                    if (!area[x][y].getCounter()) {area[x][y].weighting((int)farFromCounter(x,y) * 10);}    // + 카운터까지 거리 * 10
                }
            }
        }
        return findOptimizesSeat();
    }
    /* 웹서핑 하기 좋은 좌석 */
    public String webSurfing(){
        for(int x =0; x < area.length; x++){ // row
            for(int y = 0; y < area[x].length; y++){    // col
                if(area[x][y].getNumber() > 0){
                    if(area[x][y].getpNum() == 2) {area[x][y].weighting(30);}  // 2인 좌석 + 30
                    if(area[x][y].getpNum() == 1) {area[x][y].weighting(10);}  // 1인 좌석 + 10
                    if(area[x][y].getOutlet()){ area[x][y].weighting(200);} // 콘센트있는 좌석에 + 200
                    if(!area[x][y].getEntrance()) {area[x][y].weighting((int)farFromEntrance(x, y) * 3);}   // + 현관까지 거리 * 3
                    if(!area[x][y].getLowTable()) {area[x][y].weighting(20);}  // 테이블 높이가 높으면 + 20
                    if(!area[x][y].getToilet()) {area[x][y].weighting((int)farFromToliet(x,y) * 6);}    // + 화장실까지 거리 * 6
                    if(!area[x][y].getCounter()) {area[x][y].weighting((int)farFromCounter(x,y) * 5); }    // + 카운터까지 거리 * 5
                    if(area[x][y].getSofa()) {area[x][y].weighting(20);}   // 소파 자리 + 20
                    if(area[x][y].getWall()) {area[x][y].weighting(10);}   // 벽좌석 + 10
                    // 모퉁이
                }
            }
        }
        return findOptimizesSeat();
    }

}
class hollys extends Cafe{   // 서윤씨가 만든 카페 정보 (Hollys)
    private static int row = 0, col = 0, rowRange = 9, colRange = 11;
    public hollys(){
        super(rowRange, colRange);
        int cnt = 1;
        row++;  // row = 1
        for(int col = 1; col < colRange; col++){
            if(col == 2 || col == 3){setpNum(row, col, 2); setLowTable(row, col); setWall(row, col); setNumber(row, col,cnt); cnt++;}  // 1,2
            if(5<= col && col <= 8){setpNum(row, col, 8); setSofa(row, col); setNumber(row, col,cnt); cnt++;}   // 3~6
            if(col == 10) {setCounter(row, col);} // 카운터 설정
        }
        row++;  // row =2
        for(int col = 1; col < colRange; col++){
            if(col == 2 || col == 3){setpNum(row, col, 2);setLowTable(row, col);setNumber(row, col,cnt); cnt++;}  // 7,8
            if(5<= col && col <= 8){setpNum(row, col, 8); setSofa(row, col);setNumber(row, col,cnt); cnt++;}   // 9~12
            if(col == 10) {setCounter(row, col);} // 카운터 설정
        }
        row++;  // row = 3
        for(int col = 1; col < colRange; col++){
            if(col == 2 || col == 3){setpNum(row, col,4); setLowTable(row, col);setNumber(row, col,cnt); cnt++;}  // 13, 14
            if(col == 10) {setCounter(row, col);} // 카운터 설정
        }
        row++;  // row = 4
        for(int col = 1; col < colRange; col++){
            if(col == 2 || col == 3){setpNum(row, col,4); setLowTable(row, col);setNumber(row, col,cnt); cnt++;}  // 15,16
            if(col == 5 || col == 6){setpNum(row, col, 2); setLowTable(row, col); setOutlet(row, col);setNumber(row, col,cnt); cnt++;}  // 17, 18
            if(col == 7 || col == 9){setpNum(row, col, 2); setWall(row, col);setNumber(row, col,cnt); cnt++;}  // 19 20
            if(col == 10) {setCounter(row,col);} // 카운터 설정
        }
        row++;  // row = 5
        for(int col = 1; col < colRange; col++){
            if(col == 2){setpNum(row, col, 1); setOutlet(row, col); setWall(row,col);setNumber(row, col,cnt); cnt++;}   // 21
            if(col == 4){setpNum(row, col, 1); setNumber(row, col,cnt); cnt++;}  // 22
            if(col == 5 || col == 6){setpNum(row, col, 2); setOutlet(row, col);setNumber(row, col,cnt); cnt++;}  // 23, 24
            if(col == 7 || col == 9){setpNum(row, col, 2); setLowTable(row, col); setWall(row,col);setNumber(row, col,cnt); cnt++;}  // 25, 26
        }
        row++;  // row = 6
        for(int col = 1; col < colRange; col++){
            if(col == 2) {setpNum(row, col,1); setWall(row,col);setNumber(row, col,cnt); cnt++;}  // 27
            if(col == 4) {setpNum(row, col,1); setOutlet(row,col);setNumber(row, col,cnt); cnt++;} // 28
            if(col == 5 || col == 6){setpNum(row, col, 2); setOutlet(row, col);setNumber(row, col,cnt); cnt++;}  // 29, 30
            if(col == 7 || col == 9){setpNum(row, col, 2); setLowTable(row, col); setWall(row, col);setNumber(row, col,cnt); cnt++;}  // 31, 32
            if(col == 10) {setToilet(row,col);} // 화장실 설정
        }
        row++;  // row = 7
        for(int col = 1; col < colRange; col++){
            if(1 <= col && col <= 5) {setpNum(row, col,1); setOutlet(row, col); setWindow(row, col); setWall(row,col);setNumber(row, col,cnt); cnt++;} // 33 ~ 37
            if(col == 6 || col == 7) {setpNum(row, col,2); setOutlet(row, col); setWindow(row, col); setNumber(row, col,cnt); cnt++;} // 38, 39
            if(col == 8 || col == 9) {setpNum(row,col,2); setWindow(row, col); setNumber(row, col,cnt); cnt++;} // 40, 41
            if(col == 10) {setEntrance(row,col);} // 입구 설정
        }
    }
}

class startbucks extends Cafe{    // 지안씨가 만든 카페 좌석 정보 (Starbucks)
    private static int row = 0, col = 0, rowRange = 11, colRange = 10;
    public startbucks(){
        // 실제 좌석 ( 9, 8)
        super(rowRange, colRange);  // 좌석 생성 padding 포함
        int cnt = 1;
        if( row == 0 && col == 0) setEntrance(row, col);    // 입구 설정 (0,11)
        row++;  // row = 1
        for(col = 1; col < colRange; col++){
            if(col == 2 || col ==3) { setpNum(row, col, 4); setWindow(row, col); setNumber(row, col, cnt); cnt++; }  // 1,2
            if (col == 4 || col == 5) {setpNum(row, col, 2); setWindow(row, col); setNumber(row, col, cnt); cnt++; }    // 3,4
            if(col == 6 || col == 7) { setpNum(row, col, 4); setWindow(row, col); setNumber(row, col, cnt); cnt++; setWall(row, col); } // 5,6
            if (col == 8) { setpNum(row, col, 2); setWall(row, col); setOutlet(row, col); setWindow(row, col);  setNumber(row, col, cnt); cnt++; }    // 7
        }
        row++;  // row = 2
        for(col = 1; col < colRange; col++){
            if(col == 2 || col ==3) { setpNum(row, col, 4); setWindow(row, col); setNumber(row, col, cnt); cnt++; }  // 8,9
            if (col == 4 || col == 5) { setpNum(row, col, 2);setWindow(row, col);  setNumber(row, col, cnt); cnt++; }    // 10,11
            if(col == 6 || col == 7) { setpNum(row, col, 4); setWindow(row, col); setNumber(row, col, cnt); cnt++; setWall(row, col); } // 12,13
            if (col == 8) { setpNum(row, col, 2); setWall(row, col); setOutlet(row, col); setNumber(row, col, cnt); cnt++; }    // 14
        }
        row++;  // row = 3
        for(col = 1; col < colRange; col++){
            if(col == 1) { setpNum(row, col, 1); setWindow(row, col); setNumber(row, col, cnt); cnt++; }  // 15
            if (col == 2) { setpNum(row, col, 1); setOutlet(row, col); setWall(row, col); setNumber(row, col, cnt); cnt++; }    // 16
            if(col == 3 || col == 4) { setpNum(row, col, 2); setOutlet(row, col); setSofa(row, col); setWall(row, col); setNumber(row, col, cnt); cnt++; };  // 17, 18
            if (col == 5) {setpNum(row, col, 1); setOutlet(row, col); setWall(row, col); setNumber(row, col, cnt); cnt++; }    // 19
            if(col == 6 || col == 7) { setpNum(row, col, 2); setOutlet(row, col); setWall(row, col); setNumber(row, col, cnt); cnt++; } // 20, 21
            if (col == 8) { setpNum(row, col, 2); setWall(row, col); setSofa(row, col); setOutlet(row, col); setNumber(row, col, cnt); cnt++; }    // 22
        }
        row++;  // row = 4
        for(col = 1; col < colRange; col++){
            if(col == 1) { setpNum(row, col, 2); setWindow(row, col); setOutlet(row, col); setSofa(row, col); setNumber(row, col, cnt); cnt++; } // 23
            if(col == 8) { setpNum(row, col, 2); setWall(row, col); setOutlet(row, col); setNumber(row, col, cnt); cnt++; } // 24
        }
        row++;  // row = 5
        for(col = 1; col < colRange; col++){
            if(col == 1) {setpNum(row, col, 2); setWindow(row, col); setOutlet(row, col); setSofa(row, col); setNumber(row, col, cnt); cnt++;} // 25
            if(col == 8) {setpNum(row, col, 1); setWall(row, col); setOutlet(row, col); setNumber(row, col, cnt); cnt++; } // 26
        }
        row++;  // row = 6
        for(col = 1; col < colRange; col++){
            if(col == 1) { setpNum(row, col, 1); setWindow(row, col); setSofa(row, col); setNumber(row, col, cnt); cnt++; }  // 27
            if (col == 2 || col == 3) { setpNum(row, col, 2); setOutlet(row, col); setWall(row, col); setNumber(row, col, cnt); cnt++; }    // 28, 29
            if(col == 4) { setpNum(row, col, 1); setOutlet(row, col); setWall(row, col); setSofa(row, col); setNumber(row, col, cnt); cnt++; } // 30
            if (col == 5 || col == 6) {setpNum(row, col, 2); setOutlet(row, col); setWall(row, col); setNumber(row, col, cnt); cnt++; }    // 31, 32
            if(col == 7) {setpNum(row, col, 1); setOutlet(row, col); setWall(row, col); setSofa(row, col); setNumber(row, col, cnt); cnt++;} // 33
            if (col == 8) {setpNum(row, col, 2); setWall(row, col); setOutlet(row, col); setNumber(row, col, cnt); cnt++; }    // 34
        }
        row++;  // row = 7
        for(col = 1; col < colRange; col++){
            if(col == 1) { setpNum(row, col, 3); setWindow(row, col); setSofa(row, col); setOutlet(row, col); setNumber(row, col, cnt); cnt++; } // 35
            if ( 2 <= col && col <= 7)  { setCounter(row, col); }  // 카운터 설정
            if(col == 8) {setpNum(row, col, 2); setWall(row, col); setOutlet(row, col); setNumber(row, col, cnt); cnt++; } // 36
        }
        row++;  // row = 8
        for(col = 1; col < colRange; col++){
            if(col == 1) { setpNum(row, col, 3); setWindow(row, col); setSofa(row, col); setOutlet(row, col); setNumber(row, col, cnt); cnt++; } // 37
        }
        row++;  // row = 9
        for(col = 1; col < colRange; col++){
            if(col == 1) { setpNum(row, col, 3); setWindow(row, col); setSofa(row, col); setOutlet(row, col); setNumber(row, col, cnt); cnt++; } // 38
            if(col == 8) { setToilet(row, col);} // 화장실 설정
        }

    }

}
class twosome extends Cafe{ // 현진씨가 만든 카페 좌석 정보 (Twosome)
    private static int row = 0, col = 0, rowRange = 10, colRange = 12;

    public twosome(){
        // 실제 좌석 ( 8, 10 )
        super(rowRange, colRange);    // 좌석 생성 padding 포함
        int cnt = 1;
        if( row == 0 && col == (colRange - 1)) setEntrance(row, col);    // 입구 설정 (0,11)
        row++;  // row = 1
        for(col = 1; col < colRange; col++){
            if(col <= 6) { setWindow(row, col); setpNum(row, col, 4); setOutlet(row, col); setSofa(row, col); setNumber(row, col, cnt); cnt++;}  // 1 ~ 6
            if (col == (colRange - 1)) setToilet(row, col);   // 화장실 (1, 11)
        }
        row++;  // row = 2
        for(col = 1; col < colRange; col++){
            if(col <= 6) { setWindow(row, col); setpNum(row, col, 4); setOutlet(row, col); setNumber(row, col, cnt); cnt++;}    // 7 ~ 12
            else if(col == 7 || col == 10){ setWindow(row, col);  setpNum(row, col, 1); setOutlet(row, col); setWall(row, col); setNumber(row, col, cnt); cnt++;;}   // 13 , 16
            if(col == 8 || col == 9){setWindow(row, col);  setpNum(row, col, 1); setOutlet(row, col); setNumber(row, col, cnt); cnt++;}  // 14, 15
        }
        row++; // row = 3
        for(col = 1; col < colRange; col++){
            if(col == 1 || col == 3) {setWindow(row, col); setpNum(row, col, 2); setLowTable(row, col); setWall(row, col); setNumber(row, col, cnt); cnt++;}    // 17 , 18 번
            if(col == 4 || col == 6) { setpNum(row, col, 2); setLowTable(row, col); setWall(row, col); setNumber(row, col, cnt); cnt++;}    // 19, 20 번
            if(col == 7 || col == 8) {setpNum(row, col, 4); setNumber(row, col, cnt); cnt++;} // 21 , 22 번
            if(col == 9 || col == 10) {setpNum(row, col, 8); setOutlet(row, col); setNumber(row, col, cnt); cnt++;}    // 23, 24 번
        }
        row++;  // row = 4
        for(col = 1; col < colRange; col++){
            if(col == 2 || col == 4){ setLowTable(row, col); setpNum(row, col, 2); setWall(row, col); setWindow(row, col); setNumber(row, col, cnt); cnt++;}  // 25, 26
            if(col == 5 || col == 6) {setLowTable(row, col); setpNum(row, col, 2); setNumber(row, col, cnt); cnt++;}    // 27, 28
            if(col == 7 || col == 8){setpNum(row, col, 4);setNumber(row, col, cnt); cnt++;}  // 29,30
            if(col == 9 || col == 10) {setpNum(row, col, 8); setOutlet(row, col);setNumber(row, col, cnt); cnt++;}    // 31, 32
        }
        row++;  // row = 5
        for(col = 1; col < colRange; col++){
            if(col == 2 || col == 4){ setLowTable(row, col); setpNum(row, col, 2); setWall(row, col); setWindow(row, col);setNumber(row, col, cnt); cnt++;}  // 33, 34
            if(col == 5 || col == 6) {setLowTable(row, col); setpNum(row, col, 2); setNumber(row, col, cnt); cnt++;}    // 35, 36
            if(col == 7 || col == 8){setpNum(row, col, 4);setNumber(row, col, cnt); cnt++;}  // 37, 38
            if(col == 9 || col == 10) {setpNum(row, col, 8); setOutlet(row, col);setNumber(row, col, cnt); cnt++;}    // 39, 40
            if(col == (colRange -1)) {setCounter(row, col);}   // 카운터 설정 (1 + 4, 11)
        }
        row++;  // row = 6
        setEntrance(row, 0);    // 입구 설정 (1 + 5, 0)
        for(col = 1; col < colRange; col++){
            if(col == 7 || col == 8){setpNum(row, col, 4);setNumber(row, col, cnt); cnt++;}  // 41, 42
            if(col == 9 || col == 10) {setpNum(row, col, 8); setOutlet(row, col);setNumber(row, col, cnt); cnt++;}    // 43, 44
            if(col == (colRange -1)) {setCounter(row, col);}   // 카운터 설정 (1 + 5, 11)
        }
        row++;  // row = 7
        for(col = 1; col < colRange; col++){
            if(1 < col && col < 8) {setpNum(row, col, 4); if( col == 2 || col == 3){setWindow(row, col);} setNumber(row, col, cnt); cnt++;}  // 45 ~ 50
            if(col == 8) {setpNum(row, col, 2) ;setNumber(row, col, cnt); cnt++;}   // 51
            if(col == (colRange -1)) {setCounter(row, col);}   // 카운터 설정 (1 + 6, 11)
        }
        row++;  // row = 8
        for(col = 1; col < colRange; col++){
            if(1 < col && col < 8) {setpNum(row, col, 4); setSofa(row, col); if( col == 2 || col == 3){setWindow(row, col);} setNumber(row, col, cnt); cnt++;}  // 52 ~ 57
            if(col == 8) {setpNum(row, col, 2); setSofa(row, col);setNumber(row, col, cnt); cnt++;}   // 58
            if(col == 10) {setSpeaker(row, col);}   // 스피커 설정 (1+7, 10)
            if(col == (colRange -1)) {setCounter(row, col);}   // 카운터 설정 (1 + 7, 11)
        }
    }
}
class tomntoms extends Cafe{    // 수연씨가 만든 카페 정보 (TomnToms)
    private static int row = 0, col = 0, rowRange = 12, colRange = 13;
    public tomntoms(){
        super(rowRange, colRange);
        int cnt = 1;
        row++;  // row = 1
        for(col = 1; col < colRange; col++){
            if(1 <= col && col <= 6) { setpNum(row, col, 4); setLowTable(row, col); setWindow(row, col); setNumber(row, col, cnt); cnt++;}  // 1 ~ 6
            if(7 <= col && col <= 11) { setpNum(row, col, 2); setLowTable(row, col); setWindow(row, col); setNumber(row, col, cnt); cnt++;}    // 7 ~ 11
            if(col == (colRange -1)) {setEntrance(row,col);}    // 현관 설정
        }
        row++;  // row = 2
        for(col = 1; col < colRange; col++){
            if(1 <= col && col <= 6) { setpNum(row, col, 4); setLowTable(row, col); setWindow(row, col); setNumber(row, col, cnt); cnt++;} // 12 ~ 17
            if(7 <= col && col <= 11) { setpNum(row, col, 2); setLowTable(row, col); setWindow(row, col); setNumber(row, col, cnt); cnt++;} // 18 ~ 22
            if(col == (colRange -1)) {setCounter(row, col);}    // 카운터 설정
        }
        row++;  // row = 3
        if(col == 3) {setToilet(row, col);} // 화장실 설정   (3,3)
        for(col = 1; col < colRange; col++){
            if( col == 5 || col == 6) { setpNum(row, col, 4); setLowTable(row, col); setNumber(row, col, cnt); cnt++;} // 23, 24
            if (col == 7 || col == 8) { setpNum(row, col, 4); setLowTable(row, col); setOutlet(row, col); setNumber(row, col, cnt); cnt++;if(col == 8) { setWall(row, col);}} // 25, 26
            if(col == (colRange - 1)) { setCounter(row, col); }     // 카운터 설정
        }
        row++;  // row = 4
        for(col = 1; col <colRange; col++){
            if( col == 5 || col == 6) { setpNum(row, col, 4); setLowTable(row, col); setNumber(row, col, cnt); cnt++;} // 27, 28
            if (col == 7 || col == 8) { setpNum(row, col, 4); setLowTable(row, col); setOutlet(row, col); setNumber(row, col, cnt); cnt++;if(col == 8) { setWall(row, col);}} // 29, 30
            if(col == (colRange - 1)) { setCounter(row, col); } // 카운터 설정
        }
        row++;  // row = 5
        for(col = 1; col <colRange; col++){
            if(col == 3) { setpNum(row, col, 2); setOutlet(row, col); setSofa(row, col); setNumber(row, col, cnt); cnt++;} // 31
            if( col == 5 || col == 6) { setpNum(row, col, 4); setNumber(row, col, cnt); cnt++;} // 32, 33
            if (col == 7 || col == 8) { setpNum(row, col, 4); setOutlet(row, col); setNumber(row, col, cnt); cnt++; if(col == 8) { setWall(row, col);}} // 34, 35
            if(col == (colRange - 1)) {setCounter(row, col);}    // 카운터 설정
        }
        row++;  // row = 6
        for(col = 1; col <colRange; col++){
            if(col == 3) { setpNum(row, col, 2); setOutlet(row, col); setSofa(row, col); setNumber(row, col, cnt); cnt++;} // 36
            if( col == 5 || col == 6) { setpNum(row, col, 4); setNumber(row, col, cnt); cnt++;} // 37, 38
            if (col == 7 || col == 8) { setpNum(row, col, 4); setOutlet(row, col); setNumber(row, col, cnt); cnt++; if(col == 8) { setWall(row, col);}} // 39, 40
            if( col == 10 || col == 11) { setpNum(row, col, 8); setNumber(row, col, cnt); cnt++;}  // 41, 42
        }
        row++;  // row = 7
        for(col = 1; col <colRange; col++){
            if(col == 3) {setpNum(row, col, 2); setOutlet(row, col); setSofa(row, col); setNumber(row, col, cnt); cnt++;} // 43
            if( col == 10 || col == 11) {setpNum(row, col, 8); setNumber(row, col, cnt); cnt++;}  // 44, 45
        }
        row++;  // row = 8
        for(col = 1; col <colRange; col++){
            if(col == 3) { setpNum(row, col, 2); setOutlet(row, col); setSofa(row, col); setNumber(row, col, cnt); cnt++;} // 46
            if( col == 10 || col == 11) { setpNum(row, col, 8); setNumber(row, col, cnt); cnt++;}  // 47, 48
        }
        row++;  // row = 9
        for(col = 1; col <colRange; col++){
            if(col == 3) { setpNum(row, col, 2); setOutlet(row, col); setSofa(row, col); setNumber(row, col, cnt); cnt++;} // 49
            if( 5 <= col && col <= 7) { setpNum(row, col, 1); setOutlet(row, col); setWall(row, col); setNumber(row, col, cnt); cnt++;}  // 50 ~ 52
            if( col == 8 || col == 9) { setpNum(row, col, 2); setOutlet(row, col); setWall(row, col); setNumber(row, col, cnt); cnt++;} // 53, 54
            if( col == 10 || col == 11) { setpNum(row, col, 8); setNumber(row, col, cnt); cnt++;} // 55, 56
        }
        row++;  // rol = 10
        for(col = 1; col < colRange; col++){
            if(col == 3) { setpNum(row, col, 2); setOutlet(row, col); setSofa(row, col); setNumber(row, col, cnt); cnt++; } // 57
            if(col == 11) { setEntrance(row, col);} // 현관 설정
        }
    }
}
