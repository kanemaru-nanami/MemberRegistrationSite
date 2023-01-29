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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.UserRegisterRequest;
import com.example.demo.dto.UserRequest;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

// コントローラクラスであることの宣言
@Controller
public class RegistrationController<RBean> {

    /**
     * ユーザー情報 Service
     */
    @Autowired
    UserService userService;

	/*
	 * ホーム画面
	 */

	// リクエストURLに対しての処理メソッド定義
	@RequestMapping("/")
	public String start() {
		return "index.html";
	}

	  /**
	   * ユーザー新規登録画面を表示
	   * @param model Model
	   * @return ユーザー登録画面
	   */
	@RequestMapping(value="/a")
	public String displayAdd(Model model) {
        model.addAttribute("userRequest", new UserRequest());
		return "a.html";
	}

	 /**
	   * ユーザー情報確認画面を表示
	   * @param userRequest リクエストデータ
	   * @param model Model
	   * @return 入力確認画面
	   */
	@RequestMapping(value="/register", method =RequestMethod.POST)
	public String register(@Validated @ModelAttribute User user, Long id, Model model, BindingResult result) {

		if(result.hasErrors()) {
			// 入力チェックエラーの場合
			List<String> errorList = new ArrayList<String>();

			for (ObjectError error : result.getAllErrors()) {
		        errorList.add(error.getDefaultMessage());
		      }
		      model.addAttribute("validationError", errorList);
		      return "a.html";
		    }

	    UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
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
	    return "register.html";
	  }

	  /**
	   * ユーザー新規登録完了
	   * @param userRequest リクエストデータ
	   * @param model Model
	   * @return 入力情報完了画面
	   */
	@RequestMapping(value="/b", method = RequestMethod.POST)
	// model=ModelとViewを保持するオブジェクト
	public String create(@ModelAttribute UserRegisterRequest ur, User user, Long id, Model model) {
		    // ユーザー情報の登録
		    userService.create(ur);
		    return "b.html";
		  }
	}