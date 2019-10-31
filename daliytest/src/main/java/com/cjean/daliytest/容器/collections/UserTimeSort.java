package com.cjean.daliytest.容器.collections;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class UserTimeSort {

	public static class UserBean {
		private String id;
		private String birthday;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getBirthday() {
			return birthday;
		}

		public void setBirthday(String birthday) {
			this.birthday = birthday;
		}

		@Override
		public String toString() {
			return "UserBean [id=" + id + ", birthday=" + birthday + "]";
		}
		
		
	}

	private static void UserListGenerate(List<UserBean> list) {
		UserBean user1 = new UserBean();
		UserBean user2 = new UserBean();
		UserBean user3 = new UserBean();
		user1.setId("zhagnsan");
		user1.setBirthday("1980-11-01");

		user2.setId("lisi");
		user2.setBirthday("1981-12-01");

		user3.setId("wangwu");
		user3.setBirthday("1980-12-01");

		list.add(user1);
		list.add(user2);
		list.add(user3);
	}
	/**
	 * 时间正序 从小到大
	 * @param list
	 */
	private static void ListSort(List<UserBean> list) {
		Collections.sort(list, new Comparator<UserBean>() {
			@Override
			public int compare(UserBean o1, UserBean o2) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date dt1 = format.parse(o1.getBirthday());
					Date dt2 = format.parse(o2.getBirthday());
					if (dt1.getTime() > dt2.getTime()) {
						return 1;
					} else if (dt1.getTime() < dt2.getTime()) {
						return -1;
					} else {
						return 0;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return 0;
			}
		});
		
	}
	/**
	 * 时间倒序 从大到小
	 * @param list
	 */
	private static void ListSort1(List<UserBean> list) {
		Collections.sort(list, new Comparator<UserBean>() {
			@Override
			public int compare(UserBean o1, UserBean o2) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				try {
					
					Date dt1 = format.parse(o1.getBirthday());
					Date dt2 = format.parse(o2.getBirthday());
					
					/**
					 *	 o1 是第一个参数 		o2是第二个参数 
					 * 			 第一个参数compareTo第二个参数是 正序 从小到大
					 * 			第二个参数比较第一个参数是倒序  从大到小
					 */
					
					return dt2.compareTo(dt1);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				return 0;
			}
		});
	}
	
	/**
	 * id倒序 从大到小
	 * @param list
	 */
	private static void ListSort2(List<UserBean> list) {
		Collections.sort(list, new Comparator<UserBean>() {
			@Override
			public int compare(UserBean o1, UserBean o2) {
				try {
					/**
					 *	 o1 是第一个参数 		o2是第二个参数 
					 * 			 第一个参数compareTo第二个参数是 正序 从小到大
					 * 			第二个参数比较第一个参数是倒序  从大到小
					 */
					
					return o2.getId().compareTo(o1.getId());
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				return 0;
			}
		});
	}
	

	public static void main(String[] args) {
		List<UserBean> list = new ArrayList<UserBean>();
		List<UserBean> list1 = new ArrayList<UserBean>();
		List<UserBean> list2 = new ArrayList<UserBean>();
		UserListGenerate(list);
		System.out.println("********排序前*******");
		 for(UserBean user: list){
			 System.out.println(user.toString());
			 System.out.println(user.getBirthday());
		}
		 list1 = list;
		 list2 = list;
		 
		ListSort(list);
		System.out.println("******从小到大  正序 排序后*****");
		 for(UserBean user: list){
			 System.out.println(user.toString());
			 System.out.println(user.getBirthday());
		 }
		 
		 ListSort1(list1);
		System.out.println("******从大到小  倒序 排序后*****");
		 for(UserBean user: list1){
			 System.out.println(user.toString());
			 System.out.println(user.getBirthday());
		 }
		 ListSort2(list2);
			System.out.println("*****id倒序*从大到小  倒序 排序后*****");
			 for(UserBean user: list2){

				 System.out.println(user.id.hashCode());
				 System.out.println(user.toString());
				 System.out.println(user.getBirthday());
			 }
		 
	}

}
