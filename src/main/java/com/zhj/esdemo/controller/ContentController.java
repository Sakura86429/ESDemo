package com.zhj.esdemo.controller;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/7/24 20:42
 */

import com.zhj.esdemo.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 前端请求编写
 */
@Controller
public class ContentController {

    @Autowired
    ContentService contentService;

    @GetMapping("/parse/{keyword}")
    @ResponseBody
//    public Boolean test(@PathVariable String keyword) throws IOException {
    public String test(@PathVariable String keyword) throws IOException {
        Boolean parseContext = contentService.parseContext(keyword);
        System.out.println("keyword = " + keyword);   // true
        System.out.println("parseContext = " + parseContext);   // true
        // 输入书本
        String[] myData = new String[] {
//        "平板电视", "家庭影音", "对开门", "洗烘一体", "壁挂式空调", "立柜式空调", "烟灶", "热水器", "冰箱洗衣机",
//                "平板","厨房小电","吸尘器","电烤箱","点吹风机","滚轴洗衣机","全自动洗衣机","大容量洗衣机","微波炉","豆浆机","集成灶","变频空调","蒸烤一体",
//                "天然气","抽油烟机","电饭煲","电子书","网络原创","数字杂志","多媒体图书","音乐","影视","教育音像","少儿英文读物","文学读物","文学传记",
//                "历史书","哲学书","国学书","政治书","军事书","法律书","人文社科书","心理学书","文化书","社会科学书","生活","健身与保健","家庭与育儿","旅游",
//                "烹饪美食","工业科技","科普读物","建筑","医学","科学与自然","计算机与互联网","电子通信","中小学教辅","教育与考试","外语学习","大中专教材",

//                "字典词典","工具书","经济","金融与投资","励志与成功","杂志期刊","套装书","婴幼儿奶粉","孕妈奶粉","婴儿尿裤","拉拉裤","婴儿湿巾",
//                "成人尿裤","婴儿纸尿片","婴儿推车","婴幼儿餐椅","婴儿床","学步车","三轮车","自行车","电动车","扭扭车","滑板车","婴儿床垫","儿童摇椅",
//                "儿童滑步车","出行用品","产后塑身","文胸","内裤","防辐射服","孕妇装","孕期营养","孕产妇洗护","待产护理","孕产妇家居服",
//                "孕产妇哺乳装","孕期营养","孕产妇洗护","待产护理","哺乳用品","孕产妇鞋帽袜","袜子","旗袍唐装","民族服装","家居服","内衣裤","毛衣",
//                "针织衫","衬衫","卫衣","婴儿礼盒","外套","大衣","肚兜","马甲","T恤","校服","校服定制","羽绒服","棉服","连体衣","爬服","礼服","演出服",
//                "儿童配饰","户外","运动服","裤子","亲子装", "裙子","套装","提篮式安全座椅","增高垫","安全座椅","雨鞋","学生鞋","步前鞋",
//                "拖鞋","布鞋","编织鞋","皮鞋","帆布鞋","棉鞋","凉鞋","靴子","运动鞋","小号","吉他","钢琴","民谣吉他","电吉他",
//                "尤克里里","贝斯","提琴","古筝","月琴","胡琴","琵琶","萨克斯",

                "二胡","双簧管","单簧管","爵士吉他","空灵鼓","沙锤","旅行小吉他","笛子",
                "箫","蝶骨","钟琴","面膜","爽肤水",
                "洗面奶","底妆","眉眼","女香","男香","礼装套盒","玉兰油","底妆","爽肤水","护手霜","柔肤水","紧肤水","精华液","乳液","晚霜","眼膜",
                "美容仪","脱毛仪","美甲工具","双眼皮贴","修眉工具","眼影"};
        for (String str : myData) {
            System.out.println("parseContext = " + str);   // true
            Boolean parse = contentService.parseContext(str);
        }
        if(parseContext) return "爬取成功";
        else return "没有爬到数据";

//        return parseContext;
    }

    @GetMapping("/search/{keyword}/{pageNO}/{pageSize}")
    @ResponseBody
    public List<Map<String, Object>> search(@PathVariable("keyword") String keyword, @PathVariable("pageNO") int pageNo, @PathVariable int pageSize) throws IOException {
        List<Map<String, Object>> list = contentService.serchPageBuilder(keyword, pageNo, pageSize);
//        System.out.println(list);
        return list;
    }

    @GetMapping("/search/{keyword}")
    @ResponseBody
    public List<Map<String, Object>> searchAllData(@PathVariable("keyword") String keyword) throws IOException {
        List<Map<String, Object>> list = contentService.serchPageBuilderAll(keyword);
//        System.out.println(list);
        return list;
    }

}
