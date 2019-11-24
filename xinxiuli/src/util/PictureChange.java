package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class PictureChange {
	
	public static byte[] getByte(String photo) throws Exception{
		byte[] b = null;
		if("null".equals(photo)) {
			
		}else {
			FileInputStream fis = new FileInputStream(new File(photo));
			b = new byte[fis.available()];
			int a = fis.read(b);
		}
		return b;
		
	}
	
}
