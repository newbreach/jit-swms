package cn.jitmarketing.util.File;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TxtUtility
{
	public static void writerText(String path, String content)
	{
		File dirFile = new File(path);
		BufferedWriter bw1 = null;
		if (!dirFile.exists())
		{
			dirFile.mkdir();
		}
		try
		{
			// new FileWriter(path + "t.txt", true) 这里加入true 可以不覆盖原有TXT文件内容 续写
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			bw1 = new BufferedWriter(new FileWriter(path + "/" + simpleDateFormat.format(new Date()) + ".txt", true));
			bw1.write(content);

		} catch (IOException e)
		{
			e.printStackTrace();
		}
		if (bw1 != null)
		{
			try
			{
				bw1.flush();
				bw1.close();
			} catch (Exception e)
			{
				// TODO: handle exception
			} finally
			{
				bw1 = null;
			}
		}
	}

}
