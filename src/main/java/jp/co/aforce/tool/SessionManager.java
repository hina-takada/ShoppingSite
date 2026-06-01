package jp.co.aforce.tool;

/*
 *セッションで使用するものを管理するクラス
 * 
 */
import java.util.concurrent.ConcurrentHashMap;

import jakarta.servlet.http.HttpSession;

public class SessionManager {
// セッションとIDをMAPで保存する。
		public static ConcurrentHashMap<String, HttpSession> loginUsers =
				new ConcurrentHashMap<>();

//Map内の管理しているものを削除する
	public static void removeUser(String userId) {
		loginUsers.remove(userId);
	}
	
}
