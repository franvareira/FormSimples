package Fw;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ScreenshotFw {

   private static final String PATH_SCREENSHOT = System.getProperty("user.dir") + File.separator + "Report" + File.separator + "Screenshots";

    public static MediaEntityModelProvider takeViewpointShot(WebDriver driver) throws IOException {

            CreateFolder.createReportFolder(PATH_SCREENSHOT);

            // Converter objeto de WebDriver em TakeScreenshot e Mover arquivo
            // de imagem para o destino
            File srcShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String path = PATH_SCREENSHOT + File.separator + srcShot.getName();

            FileUtils.copyFile(srcShot, new File(path));
            return MediaEntityBuilder.createScreenCaptureFromPath(path).build();

    }

    public static void takeFullPageShot(WebDriver driver) {
        CreateFolder.createReportFolder(PATH_SCREENSHOT);

        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
                .takeScreenshot(driver);

        String path = "target" + File.separator + "screenshot" + File.separator + DateTimeFormatterFw.getTime() + ".jpg";

        try {
            ImageIO.write(screenshot.getImage(), "PNG", new File(path));

        } catch (IOException e) {
            System.out.println("Não foi posssível capturar a tela");
            e.printStackTrace();
        }
    }

    public static MediaEntityModelProvider capture(WebDriver driver) {
        try {
            CreateFolder.createReportFolder(PATH_SCREENSHOT);

            return MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64)).build();
        } catch(Exception ex) {}
        return null;
    }
}
