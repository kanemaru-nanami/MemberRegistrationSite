package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.UserRegisterRequest;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

//コントローラクラスであることの宣言
@Controller
public class UserController {

	  /**
	   * ユーザー情報 Service
	   */
	  @Autowired
	  private UserService userService;


	  /**
	   * ユーザー情報一覧画面を表示
	   * @param model Model
	   * @return ユーザー情報一覧画面
	   */
	  @RequestMapping(value = "/user/list")
	  public String displayList(Model model) {
	    List<User> userlist = userService.searchAll();
	    model.addAttribute("userlist", userlist);
	    return "user/list.html";
	  }


	  /**
	   * ユーザー情報詳細画面を表示
	   * @param id 表示するユーザーID
	   * @param model Model
	   * @return ユーザー情報詳細画面
	   */
	  @RequestMapping("/user/{id}")
	  public String displayView(@PathVariable Long id, Model model) {
	    User user = userService.findById(id);
	    model.addAttribute("userData", user);
	    return "user/view.html";
	  }


	  /**
	   * ユーザー情報削除
	   * @param id 表示するユーザーID
	   * @param model Model
	   * @return ユーザー情報詳細画面
	   */
	  @RequestMapping("/user/{id}/delete")
	  public String delete(@PathVariable Long id, Model model) {
	    // ユーザー情報の削除
	    userService.delete(id);
	    return "redirect:/user/list";
	  }


	  /**
	   * ユーザー編集画面を表示
	   * @param id 表示するユーザーID
	   * @param model Model
	   * @return ユーザー編集画面
	   */
	  @RequestMapping("/user/{id}/edit")
	  public String displayEdit(@PathVariable Long id, Model model) {
	    User user = userService.findById(id);
	    UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
	    userRegisterRequest.setId(user.getId());
	    userRegisterRequest.setYourname(user.getYourname());
	    userRegisterRequest.setFurigana(user.getFurigana());
	    userRegisterRequest.setPhonenumber(user.getPhonenumber());
	    userRegisterRequest.setAddress(user.getAddress());
	    userRegisterRequest.setBirthday(user.getBirthday());
	    userRegisterRequest.setGender(user.getGender());
	    userRegisterRequest.setJob(user.getJob());
	    userRegisterRequest.setLive(user.getLive());
	    userRegisterRequest.setSkill(user.getSkill());
	    userRegisterRequest.setMessage(user.getMessage());
	    userRegisterRequest.setPassword(user.getPassword());
	    userRegisterRequest.setConsentChk(user.getConsentChk());
	    model.addAttribute("userRegisterRequest", userRegisterRequest);
	    return "user/edit.html";
	  }


	  /**
	   * ユーザー更新
	   * @param userRequest リクエストデータ
	   * @param model Model
	   * @return ユーザー情報詳細画面
	   */
	  @RequestMapping(value = "/user/update", method = RequestMethod.POST)
	  public String update(@Validated @ModelAttribute UserRegisterRequest userRegisterRequest, BindingResult result, Model model) {
	    if (result.hasErrors()) {
	      List<String> errorList = new ArrayList<String>();
	      for (ObjectError error : result.getAllErrors()) {
	        errorList.add(error.getDefaultMessage());
	      }
	      model.addAttribute("validationError", errorList);
	      return "user/edit.html";
	    }
	    // ユーザー情報の更新
	    userService.update(userRegisterRequest);
	    return String.format("redirect:/user/%d", userRegisterRequest.getId());
	  }

}
