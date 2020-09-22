package cn.itrip.controller;

import cn.itrip.beans.dto.Dto;
import cn.itrip.beans.pojo.User;
import cn.itrip.common.DtoUtil;
import cn.itrip.common.Page;
import cn.itrip.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class BizController {

    @Resource
    UserService userService;


    @RequestMapping("/display")
    @ResponseBody
    public Dto display(
        @RequestParam(value="page",defaultValue = "1",required = true) int pageIndex,
         @RequestParam(value = "name",required = false)   String userName){
      Page<User> pagedusers = userService.getPagedUsers(pageIndex,userName);

        return DtoUtil.returnDataSuccess(pagedusers);
    }

}
