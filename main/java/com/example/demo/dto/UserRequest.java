package com.example.demo.dto;

import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * ユーザー情報 リクエストデータ
 */
@Data
public class UserRequest implements Serializable {
	// Serializable オブジェクトを出力ストリームに書き出す
	/**
	 * 名前
	 */
	@NotEmpty(message = "名前を入力してください")
	@Size(max = 30, message = "名前は30桁以内で入力してください")
	private String yourname;
	/**
	 * ふりがな
	 */
	@NotEmpty(message = "ふりがなを入力してください")
	@Size(max = 30, message = "ふりがなは30桁以内で入力してください")
	private String furigana;
	/**
	 * 電話番号
	 */
	@Pattern(message = "電話番号の形式で入力してください" , regexp = "0\\d{1,4}-\\d{1,4}-\\d{4}")
	private String phonenumber;
	/**
	 * メールアドレス
	 */
	@Email(message = "アドレスを入力してください")
	private String address;
	/**
	 * 生年月日
	 */
	@NotEmpty(message = "生年月日を入力してください")
	private String birthday;
	/**
	 * 性別
	 */
	@NotEmpty(message = "いずれかにチェックしてください")
	private String gender;
	/**
	 * 希望する職種
	 */
	@NotEmpty(message = "いずれかにチェックしてください")
	private String job;
	/**
	 * お住まいの都道府県
	 */
	@NotEmpty(message = "いずれかにチェックしてください")
	private String live;
	/**
	 * 経験スキル(複数選択可)
	 */
	@NotEmpty(message = "いずれかにチェックしてください")
	private String skill;
	/**
	 * 自己PR
	 */
	@NotEmpty(message = "入力してください")
	@Size(max = 30, message = "自己PRは320桁以内で入力してください")
	private String message;
	/**
	 * 新規パスワード登録
	 */
	@NotEmpty(message = "パスワードを入力してください。")
	@Size(min = 8, max = 16, message = "パスワードは{min}文字以上{max}文字以下です。")
	@Pattern(regexp = "[a-zA-Z0-9]*", message = "パスワードは英数である必要があります。")
	private String password;
	/**
	 * プライバシーポリシー
	 */
	@NotEmpty(message = "登録できません")
	private String consentChk;

}