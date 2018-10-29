import java.util.*;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static int n;
    static ArrayList<Point> list = new ArrayList<>();
    static int[] bMatch;
    static int[] aMatch;
    static int[][] adj=new int[50001][50001];
    static int countX;
    static int countY;
    static int max;
    static int[] visit;
    static int visitCnt = 0;

    static boolean dfs(int a) {
        if (visit[a] == visitCnt) return false;
        visit[a] = visitCnt;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).x == a)
                if (bMatch[list.get(i).y] == -1 || dfs(bMatch[list.get(i).y])) {
                    bMatch[list.get(i).y] = a;
                    aMatch[list.get(i).x] = list.get(i).y;
                    return true;
                }
        }
        return false;
    }

    static int biMatch() {
        int answer = 0;

        for (int i = 0; i <= countX; i++)
            aMatch[i] = -1;

        for (int i = 0; i <= countY; i++)
            bMatch[i] = -1;

        for (int i = 0; i <= countX; i++) {
            visitCnt++;
            if (dfs(i)) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {

        n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            Point p = new Point(scan.nextInt(), scan.nextInt());
            list.add(p);
        }
        int cnt = 0;
        /*********x좌표 압축**********/
        Collections.sort(list, new xCompare());
        countX = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).x > cnt) {
                countX++;
                cnt = list.get(i).x;
            }
            list.get(i).x = countX;
        }


        /*********y좌표 압축**********/
        Collections.sort(list, new yCompare());
        cnt = 0;
        countY = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).y > cnt) {
                countY++;
                cnt = list.get(i).y;
            }
            list.get(i).y = countY;
        }


        if (countX > countY)
            max = countX;
        else max = countY;

        visit = new int[max + 2];
        aMatch = new int[countX + 2];
        bMatch = new int[countY + 2];

        if (biMatch() > 3)
            System.out.println(0);
        else System.out.println(1);
    }

}

class Point {
    int x;
    int y;

    public Point(int getX, int getY) {
        x = getX;
        y = getY;
    }

}

class xCompare implements Comparator<Point> {
    @Override
    public int compare(Point p1, Point p2) {
        if (p1.x > p2.x) return 1;
        else if (p1.x < p2.x) return -1;
        return 0;
    }
}

class yCompare implements Comparator<Point> {
    @Override
    public int compare(Point p1, Point p2) {
        if (p1.y > p2.y) return 1;
        else if (p1.y < p2.y) return -1;
        return 0;
    }
}
