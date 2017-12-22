package hut.reoger.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import java.util.List;



public class PrintToPng {

    // 根据str,font的样式以及输出文件目录
    public static void createImage(List<String> titles, List<String> contents, Font font, String outFileStr,
                                    Integer width, Integer height) throws Exception {
        if(font == null)
            font = new Font("微软雅黑", Font.PLAIN, 11);


        int index = outFileStr.lastIndexOf("\\");
        String str  = outFileStr.substring(0,index);
        File dir =  new File(str);
        if(!dir.exists()){
            System.out.println("不存在目录"+str+"，已自动创建");
            dir.mkdir();
        }
        File outFile = new File(outFileStr);


        // 创建图片
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_BGR);
        Graphics g = image.getGraphics();
        g.setClip(0, 0, width, height);
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);// 先用黑色填充整张图片,也就是背景
        g.setColor(Color.black);// 在换成黑色
        g.setFont(font);// 设置画笔字体
        /** 用于获得垂直居中y */
        Rectangle clip = g.getClipBounds();
        FontMetrics fm = g.getFontMetrics(font);
        int ascent = fm.getAscent();
        int descent = fm.getDescent();
        int y = (clip.height - (ascent + descent)) / 2 + ascent;

        int x = 0;
        for(int i=0;i<titles.size();i++){
            g.drawLine(x,0,x,height);
            g.drawString(titles.get(i),x+ascent,(y-ascent-descent)/2+ascent);
            x+=80;
        }


        g.drawLine(0,y,width,y);

        x = 0;
        for (int i = 0; i < contents.size(); i++) {

            g.drawString(contents.get(i),x+ascent,(y+ascent+descent)/2+2*ascent);
            x+=80;
        }

        g.dispose();
        ImageIO.write(image, "png", outFile);// 输出png图片
    }
}
