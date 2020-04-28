package com.example.api.service;

import java.awt.*;
import java.util.List;

/**
 * @author yzx
 * @date 2020/4/28  11:06
 */
public class KMeansClusterService {

    private int k;//簇的个数
    private int num = 100000;//迭代次数
    private List<double> datas;//原始样本集
    private String address;//样本集路径
    private List<point> data = new ArrayList<point>();
    private AbstractDistance distance = new AbstractDistance() {
        @Override
        public double getDis(Point p1, Point p2) {
            //欧几里德距离
            return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
        }
    };

    public KMeansCluster(int k, int num, String address) {
        this.k = k;
        this.num = num;
        this.address = address;
    }

    public KMeansCluster(int k, String address) {
        this.k = k;
        this.address = address;
    }

    public KMeansCluster(int k, List<double> datas) {
        this.k = k;
        this.datas = datas;
    }

    public KMeansCluster(int k, int num, List<double> datas) {
        this.k = k;
        this.num = num;
        this.datas = datas;
    }

    private void check() {
        if (k == 0)
            throw new IllegalArgumentException("k must be the number > 0");

        if (address == null && datas == null)
            throw new IllegalArgumentException("program can't get real data");
    }

    /**
     * 初始化数据
     *
     * @throws java.io.FileNotFoundException
     */
    public void init() throws FileNotFoundException {
        check();
        //读取文件，init data
        //处理原始数据
        for (int i = 0, j = datas.size(); i < j; i++)
            data.add(new Point(i, datas.get(i), 0));
    }

    /**
     * 第一次随机选取中心点
     *
     * @return
     */
    public Set<point> chooseCenter() {
        Set<point> center = new HashSet<point>();
        Random ran = new Random();
        int roll = 0;
        while (center.size() < k) {
            roll = ran.nextInt(data.size());
            center.add(data.get(roll));
        }
        return center;
    }

    /**
     * @param center
     * @return
     */
    public List<cluster> prepare(Set<point> center) {
        List<cluster> cluster = new ArrayList<cluster>();
        Iterator<point> it = center.iterator();
        int id = 0;
        while (it.hasNext()) {
            Point p = it.next();
            if (p.isBeyond()) {
                Cluster c = new Cluster(id++, p);
                c.addPoint(p);
                cluster.add(c);
            } else
                cluster.add(new Cluster(id++, p));
        }
        return cluster;
    }

    /**
     * 第一次运算，中心点为样本值
     *
     * @param center
     * @param cluster
     * @return
     */
    public List<cluster> clustering(Set<point> center, List<cluster> cluster) {
        Point[] p = center.toArray(new Point[0]);
        TreeSet<distence> distence = new TreeSet<distence>();//存放距离信息
        Point source;
        Point dest;
        boolean flag = false;
        for (int i = 0, n = data.size(); i < n; i++) {
            distence.clear();
            for (int j = 0; j < center.size(); j++) {
                if (center.contains(data.get(i)))
                    break;

                flag = true;
                // 计算距离
                source = data.get(i);
                dest = p[j];
                distence.add(new Distence(source, dest, distance));
            }
            if (flag == true) {
                Distence min = distence.first();
                for (int m = 0, k = cluster.size(); m < k; m++) {
                    if (cluster.get(m).getCenter().equals(min.getDest()))
                        cluster.get(m).addPoint(min.getSource());

                }
            }
            flag = false;
        }

        return cluster;
    }

    /**
     * 迭代运算，中心点为簇内样本均值
     *
     * @param cluster
     * @return
     */
    public List<cluster> cluster(List<cluster> cluster) {
        //        double error;
        Set<point> lastCenter = new HashSet<point>();
        for (int m = 0; m < num; m++) {
            //            error = 0;
            Set<point> center = new HashSet<point>();
            // 重新计算聚类中心
            for (int j = 0; j < k; j++) {
                List<point> ps = cluster.get(j).getMembers();
                int size = ps.size();
                if (size < 3) {
                    center.add(cluster.get(j).getCenter());
                    continue;
                }
                // 计算距离
                double x = 0.0, y = 0.0;
                for (int k1 = 0; k1 < size; k1++) {
                    x += ps.get(k1).getX();
                    y += ps.get(k1).getY();
                }
                //得到新的中心点
                Point nc = new Point(-1, x / size, y / size, false);
                center.add(nc);
            }
            if (lastCenter.containsAll(center))//中心点不在变化，退出迭代
                break;
            lastCenter = center;
            // 迭代运算
            cluster = clustering(center, prepare(center));
            //            for (int nz = 0; nz < k; nz++) {
            //                error += cluster.get(nz).getError();//计算误差
            //            }
        }
        return cluster;
    }

    /**
     * 输出聚类信息到控制台
     *
     * @param cs
     */
    public void out2console(List<cluster> cs) {
        for (int i = 0; i < cs.size(); i++) {
            System.out.println("No." + (i + 1) + " cluster:");
            Cluster c = cs.get(i);
            List<point> p = c.getMembers();
            for (int j = 0; j < p.size(); j++) {
                System.out.println("\t" + p.get(j).getX() + " ");
            }
            System.out.println();
        }
    }
}
