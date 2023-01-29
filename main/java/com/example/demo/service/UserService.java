package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.UserRegisterRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

// ユーザー情報 Service
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {

	/**
	 * ユーザー情報 Repository
	 */
	@Autowired
	private UserRepository userRepository;


    /**
	 * ユーザー情報 全検索
	 * @return 検索結果
	 */
	public List<User> searchAll(){
		return userRepository.findAll();
	}


	  /**
	   * ユーザー情報 主キー検索
	   * @return 検索結果
	   */
	  public User findById(Long id) {
	    return userRepository.findById(id).get();
	  }


	  /**
	   * ユーザー情報 物理削除
	   * @param id ユーザーID
	   */
	  public void delete(Long id) {
	    User user = findById(id);
	    userRepository.delete(user);
	  }


    /**
     * ユーザー情報新規登録
     * @param User ユーザー情報
     */
    public void create(UserRegisterRequest ur) {
        userRepository.save(CreateUser(ur));
    }


    /**
     * ユーザーTBLエンティティの生成
     * @param userRequest ユーザー情報リクエストデータ
     * @return ユーザーTBLエンティティ
     */
    public User CreateUser(UserRegisterRequest ur) {
        User user = new User();
		user.setYourname(ur.getYourname());
		user.setFurigana(ur.getFurigana());
		user.setPhonenumber(ur.getPhonenumber());
		user.setAddress(ur.getAddress());
		user.setBirthday(ur.getBirthday());
		user.setGender(ur.getGender());
		user.setJob(ur.getJob());
		user.setLive(ur.getLive());
		user.setSkill(ur.getSkill());
		user.setMessage(ur.getMessage());
		user.setPassword(ur.getPassword());
		user.setConsentChk(ur.getConsentChk());
		return user;
	}


    /**
     * ユーザー情報 更新
     * @param user ユーザー情報
     */
    public void update(UserRegisterRequest userRegisterRequest) {
      User user = findById(userRegisterRequest.getId());
      user.setYourname(userRegisterRequest.getYourname());
      user.setFurigana(userRegisterRequest.getFurigana());
      user.setPhonenumber(userRegisterRequest.getPhonenumber());
      user.setAddress(userRegisterRequest.getAddress());
      user.setBirthday(userRegisterRequest.getBirthday());
      user.setGender(userRegisterRequest.getGender());
      user.setJob(userRegisterRequest.getJob());
      user.setLive(userRegisterRequest.getLive());
      user.setSkill(userRegisterRequest.getSkill());
      user.setMessage(userRegisterRequest.getMessage());
      user.setPassword(userRegisterRequest.getPassword());
      user.setConsentChk(userRegisterRequest.getConsentChk());
      userRepository.save(user);
    }
}
