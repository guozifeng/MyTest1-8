package com.guo.MyTest18;

import java.util.Optional;

public class testOptional {
	
	//ʹ��Optional�����ǾͿ��԰����������Ĵ�����и�д��
	public static String getName0(User u) {
		if (u == null)
			return "Unknown";
		return u.name;
	}

	//������ǧ��Ҫ��д���⸱���ӡ�
	public static String getName1(User u) {
		Optional<User> user = Optional.ofNullable(u);
		if (!user.isPresent())
			return "Unknown";
		return user.get().name;
	}

	//������д�ǵ�����࣬������������Ǻ͵�һ�δ���һ�����޷Ǿ�����isPresent���������u==null�������ĸ�д������Optional��ȷ���÷�������������дһ�Ρ�
	public static String getName2(User u) {
		return Optional.ofNullable(u).map(user -> user.name).orElse("Unknown");
	}
	
	public static String getChampionName(Competition comp) throws IllegalArgumentException {
	    if (comp != null) {
	        CompResult result = comp.getCompResult();
	        if (result != null) {
	            User champion = result.getUser();
	            if (champion != null) {
	                return champion.getName();
	            }
	        }
	    }
	    throw new IllegalArgumentException("The value of param comp isn't available.");
	}
	
	public static String getChampionName1(Competition comp) throws IllegalArgumentException {
	    return Optional.ofNullable(comp)
	            .map(c->c.getCompResult())
	            .map(r->r.getUser())
	            .map(u->u.getName())
	            .orElseThrow(()->new IllegalArgumentException("The value of param comp isn't available."));
	}
}
