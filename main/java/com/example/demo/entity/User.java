package com.example.demo.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * ユーザー情報 Entity
 */
@Data
@Entity
@Table(name = "user")
// Serializable オブジェクトを出力ストリームに書き出す
public class User implements Serializable {
	/**
	 * ID
	 */
	@Id
    @Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * 名前
	 */
    @Column(name = "yourname")
	private String yourname;
    /**
     * ふりがな
     */
    @Column(name = "furigana")
    private String furigana;
    /**
     * 電話番号
     */
    @Column(name = "phonenumber")
	private String phonenumber;
    /**
     * 住所
     */
    @Column(name = "address")
	private String address;
    /**
     * 誕生日
     */
    @Column(name = "birthday")
    private String birthday;
    /**
     * 性別
     */
    @Column(name = "gender")
    private String gender;
    /**
     * 希望する職種
     */
    @Column(name = "job")
    private String job;
    /**
     * お住まいの都道府県
     */
    @Column(name = "live")
    private String live;
    /**
     * 経験スキル
     */
    @Column(name = "skill")
    private String skill;
    /**
     * 自己PR
     */
    @Column(name = "message")
    private String message;
    /**
     * パスワード
     */
    @Column(name = "password")
    private String password;
    /**
     * プライバシーポリシー
     */
    @Column(name = "consentChk")
    private String consentChk;


  //デフォルトコンストラクタ
	public User() {}


	public User(Long id, String yourname, String furigana, String phonenumber, String address, String birthday, String gender, String job, String live, String skill, String message, String password, String consentChk) {
		this.id = id;
		this.yourname = yourname;
		this.furigana = furigana;
		this.phonenumber = phonenumber;
		this.address = address;
		this.birthday = birthday;
		this.gender = gender;
		this.job = job;
		this.live = live;
		this.skill = skill;
		this.message = message;
		this.password = password;
		this.consentChk = consentChk;
	}

}