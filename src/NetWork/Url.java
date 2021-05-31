package NetWork;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class Url {
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://img.netbian.com/file/2020/0904/de2f77ed1090735b441ba5e4c2b460ca.jpg");
		HttpURLConnection uc = (HttpURLConnection) url.openConnection();
		InputStream is = uc.getInputStream();
		FileOutputStream fos = new FileOutputStream("img.jpg");
		byte[] bytes = new byte[1024 * 1024];
		int counter;
		while ((counter = is.read(bytes)) != -1) {
			fos.write(bytes, 0, counter);
		}

		fos.close();
		is.close();
		uc.disconnect();
	}
}
