package cn.jitmarketing.util.File;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtils {
	/**
	 * 文件copy方法
	 * 
	 * @param src
	 * @param dest
	 */
	public static void copy(InputStream src, OutputStream dest) {
		try {
			byte[] tmp = new byte[1024];
			int len = -1;
			while ((len = src.read(tmp)) != -1)
				dest.write(tmp, 0, len);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 给文件重命名 防止覆盖
	 * 
	 * @param fileName
	 * @return 时间戳+原始文件的后缀
	 */
	public static String reName(String fileName) {
		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyMMddHHmmss");
		StringBuffer sbBuffer = new StringBuffer();
		sbBuffer.append(simpleDateFormat1.format(new Date()));
		sbBuffer.append("/");
		sbBuffer.append(simpleDateFormat2.format(new Date()));
		sbBuffer.append(fileName.substring(fileName.indexOf(".")));
		return sbBuffer.toString();
	}

	/**
	 * 文件保存
	 * 
	 * @param fileName
	 *          reName之后的文件名称
	 * @param content
	 * @param filePath
	 *          文件保存路径
	 * @return
	 * @throws IOException
	 */
	public static void saveFile(String targetFileName, InputStream content) throws IOException {
		FileOutputStream fos = null;
		try {
			File pictureFile = new File(targetFileName);
			File pf = pictureFile.getParentFile();
			if (!pf.exists()) {
				pf.mkdirs();
			}
			pictureFile.createNewFile(); // 创建文件
			fos = new FileOutputStream(pictureFile);
			FileUtils.copy(content, fos);
		} catch (Exception e) {
			throw new IOException("文件保存失败!");
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (Exception e) {
					throw new IOException("文件保存失败!");
				} finally {
					fos = null;
				}
			}
		}
	}

	public static void deleteEmptyFolder(File file) {
		if (file.exists()) {// 判断文件是否存在
			if (file.isFile()) {// 判断是否是文件
				// file.delete();// 删除文件
			} else if (file.isDirectory()) {// 否则如果它是一个目录
				File[] files = file.listFiles();// 声明目录下所有的文件 files[];
				for (int i = 0; i < files.length; i++) {// 遍历目录下所有的文件
					deleteEmptyFolder(files[i]);// 把每个文件用这个方法进行迭代
				}
				file.delete();// 删除文件夹
			}
		} else {
			System.out.println("所删除的文件不存在");
		}
	}
	
	
	// 删除附件
	public static void delFile(File file)
	{
		file.delete();
	}
}
