package com.kosa.controller;

import com.kosa.controller.action.*;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();

	private ActionFactory() {
		super();
	}

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory  :" + command);
		/* 추가된 부분 */
		if (command.equals("index")) {
			action = new IndexAction();
		} else if (command.equals("product_detail")) {
			action = new ProductDetailAction();
		} else if (command.equals("product_All")) {
			action = new ProductAllAction();
		} else if (command.equals("product_by_category")) {
			action = new ProductByCategoryAction();
		} else if (command.equals("product_sale")) {
			action = new ProductSaleAction();
		} else if (command.equals("prouduct_new")) {
			action = new ProductNewAction();
		} else if (command.equals("member_form")) {
			action = new MemberFormAction();
		} else if (command.equals("id_check_form")) {
			action = new IdCheckFormAction();
		} else if (command.equals("nick_check_form")) {
			action = new NickCheckFormAction();
		} else if (command.equals("tel_check_form")) {
			action = new TelCheckFormAction();
		} else if (command.equals("email_check_form")) {
			action = new EmailCheckFormAction();
		} else if (command.equals("join")) {
			action = new JoinAction();
		} else if (command.equals("login_form")) {
			action = new LoginFormAction();
		} else if (command.equals("login")) {
			action = new LoginAction();
		} else if (command.equals("logout")) {
			action = new LogoutAction();
		} else if (command.equals("basket_insert")) {
			action = new BasketInsertAction();
		} else if (command.equals("basket_list")) {
			action = new BasketListAction();
		} else if (command.equals("basket_delete")) {
			action = new BasketDeleteAction();
		} else if (command.equals("order_insert")) {
			action = new OrderInsertAction();
		} else if (command.equals("order_list")) {
			action = new OrderListAction();
		} else if (command.equals("mypage")) {
			action = new MyPageAction();
		} else if (command.equals("mypage_update")) {
			action = new MyPageUpdateAction();
		} else if (command.equals("mypage_member_delete")) {
			action = new MyPageMemberDeleteAction();
		} else if (command.equals("order_list_detail")) {
			action = new OrderListDetailAction();
		} else if (command.equals("order_list_all")) {
			action = new OrderListAllAction();
		} else if (command.equals("order_list_update")) {
			action = new OrderListUpdateAction();
		} else if (command.equals("order_list_delete")) {
			action = new OrderListDeleteAction();
		} else if (command.equals("inquiry_list")) {
			action = new InquiryListAction();
		} else if (command.equals("inquiry_insert")) {
			action = new InquiryInsertAction();
		} else if (command.equals("inquiry_delete")) {
			action = new InquiryDeleteAction();
		} else if (command.equals("password_check")) {
			action = new PasswordCheckAction();
		}

		return action;
	}
}