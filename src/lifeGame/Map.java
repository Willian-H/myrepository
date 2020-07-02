package lifeGame;

import java.util.Random;

public class Map {
    final static public int x=16;
    final static public int y=16;

    //初始化地图细胞存活状态
    public static Cell [][]initial() {
        Cell [][]cell=new Cell[x][y];
        for(int i=0;i<x;i++) {
            for(int j=0;j<y;j++) {
                cell[i][j]=new Cell();
                //随机生成初始状态
                Random random=new Random();
                cell[i][j].setStatus(random.nextInt(2));
                //cell[i][j].setStatus(1);
            }
        }
        return cell;
    }

    //初始化每个细胞周围存活的细胞的个数
    public static void getLiving(Cell [][]cell){
        for(int i=0;i<x;i++) {
            for(int j=0;j<y;j++) {
                int living=0;
                if(i>0&&j>0) living+=cell[i-1][j-1].getStatus();
                if(i>0) living+=cell[i-1][j].getStatus();
                if(j>0) living+=cell[i][j-1].getStatus();
                if(i<x-1&&j<x-1) living+=cell[i+1][j+1].getStatus();
                if(i<x-1) living+=cell[i+1][j].getStatus();
                if(j<x-1) living+=cell[i][j+1].getStatus();
                if(i<x-1&&j>0) living+=cell[i+1][j-1].getStatus();
                if(i>0&&j<x-1) living+=cell[i-1][j+1].getStatus();
                cell[i][j].setLiving(living);
            }
        }
    }


    public static int update(Cell [][]cell){
        int count=0;
        for(int i=0;i<x;i++) {
            for(int j=0;j<y;j++) {
                int status=cell[i][j].getStatus();
                cell[i][j].UpdateStatus();
                if(status==cell[i][j].getStatus()) count++;
            }
        }
        return count;
    }

}

