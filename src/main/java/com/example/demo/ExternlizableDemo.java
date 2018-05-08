package com.example.demo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExternlizableDemo implements Externalizable {
	private String userName;
	private String password;
	private String age;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	// 在writeExternal()方法里定义了哪些属性可以序列化
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		Date date = new Date();
		out.writeObject(userName);
		out.writeObject(password);
		out.writeObject(date);

	}

	// 根据序列顺序（writeExternal的顺序）挨个读取进行反序列，并自动封装成对象返回
	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		userName = (String) in.readObject();
		password = (String) in.readObject();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = (Date) in.readObject();
		System.out.println("反序列化后的日期为:" + sdf.format(date));

	}

}
