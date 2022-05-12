import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

import org.apache.jmeter.config.Arguments;
        import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
        import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
        import org.apache.jmeter.samplers.SampleResult;
        import org.apache.jmeter.testelement.TestElement;

        import javax.naming.Name;
        import java.nio.charset.StandardCharsets;
        import java.util.concurrent.TimeUnit;

    public class taobin extends AbstractJavaSamplerClient {


    public Arguments getDefaultParameters() {

        Arguments arguments =new Arguments();
        arguments.addArgument("name","taobin");
        arguments.addArgument("ip","192.168.1.0");
        arguments.addArgument("port","8080");
        return arguments;
    }


    //成员变量
    public void setupTest(JavaSamplerContext context) {
        //创建链接的代码
    }

    @Override
    public SampleResult runTest(JavaSamplerContext context) {
        SampleResult result = new SampleResult();
        result.sampleStart();

        //固定业务代码
        result.setSuccessful(true);
        result.setSampleLabel("test_002");
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String name = context.getParameter("name");
        System.out.println("00000011"+name);

        result.setResponseData(name.getBytes(StandardCharsets.UTF_8));
        result.sampleEnd();
        return result;
    }

    public void teardownTest(JavaSamplerContext context) {
        //测试结束处理，例如关闭链接
    }

    public static void main(String[] args){
        taobin taobin=new taobin();
        JavaSamplerContext context=new JavaSamplerContext(taobin.getDefaultParameters());
        taobin.runTest(context);
        Arguments params = new Arguments();

    }

}
