package cn.ling.medicalview.controller.medical;

import cn.ling.medicalview.pojo.Doctor;
import cn.ling.medicalview.pojo.log.Log;
import cn.ling.medicalview.service.medical.DoctorService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

//@RestController
@Controller
@RequestMapping("doctor/")
public class DoctorController {
    Logger logger= LoggerFactory.getLogger(DoctorController.class);
    @Resource
    private DoctorService doctorService;

    /**
     * 获取某家医院的某科室-医生信息
     * @param hid
     * @param officeName
     * @return
     */
    @GetMapping(value = {"getDoctorInfoList/{hid}/{officeName}","getDoctorInfoList/{hid}"})
    public String getDoctorInfoList(@PathVariable(value = "hid",required = true)Integer hid,
                                          @PathVariable(value = "officeName",required = false)String officeName,
                                          Model model){
        model.addAttribute("DoctorList",doctorService.getDoctorInfoList(hid,officeName));
        logger.info("日期= "+doctorService.getDoctorInfoList(hid,officeName).get(0).getEntrydate());

        return "hospital/YuanGonglist";
    }
}
