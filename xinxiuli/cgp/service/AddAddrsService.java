package service;

import java.sql.Connection;
import java.util.List;


import pojo.Users;

public interface AddAddrsService {
	public Users addAddrs(String account_num,Users user,Connection conn) throws Exception;

}
