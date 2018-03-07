package com.jiao.mmvp.model.bean;

import com.jiao.mmvp.model.bean.movie.ImagesBean;
import com.jiao.mmvp.model.bean.movie.PersonBean;
import com.jiao.mmvp.model.bean.movie.RatingBean;

import java.util.List;

/**
 * @Description :
 * @Author : StriveJiao
 * @Date : 2018/3/7 15:16
 */

public class MovieItemBean {
    public RatingBean rating;
    public String title;
    public int collect_count;
    public String original_title;
    public String subtype;
    public String year;
    public ImagesBean images;
    public String alt;
    public String id;
    public List<String> genres;
    public List<PersonBean> casts;
    public List<PersonBean> directors;

    /**
     * 获取导演字符串
     *
     * @return 导演字符串 A/B/C..
     */
    public String getDirectorsString() {
        return pListToString(directors);
    }

    /**
     * 获取演员字符串
     *
     * @return 演员字符串 A/B/C..
     */
    public String getActorsString() {
        return pListToString(casts);
    }

    /**
     * 获取类型字符串
     *
     * @return 类型字符串 A/B/C..
     */
    public String getGenresString() {
        return sListToString(genres);
    }


    /**
     * 格式化list为字符串
     *
     * @param list 类型list
     * @return 字符串 A/B/C..
     */
    private String sListToString(List<String> list) {
        String str = "";
        if (list.size() == 0)
            return str;
        for (int i = 0; i < list.size(); i++) {
            str = str + list.get(i);
            if (i < list.size() - 1)
                str += " / ";
        }
        return str;
    }


    /**
     * 格式化list为字符串
     *
     * @param list 类型list
     * @return 字符串 A/B/C..
     */
    private String pListToString(List<PersonBean> list) {
        String str = "";
        if (list.size() == 0)
            return str;
        for (int i = 0; i < list.size(); i++) {
            str = str + list.get(i).getName();
            if (i < list.size() - 1)
                str += " / ";
        }
        return str;
    }
}
