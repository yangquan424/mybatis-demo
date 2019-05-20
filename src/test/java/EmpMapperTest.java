import com.cheer.mybatis.dao.EmpMapper;
import com.cheer.mybatis.model.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class EmpMapperTest {
    @Test
    public void getEmp(){
        String resource = "mybatis_config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = sqlSessionFactory.openSession();

            EmpMapper empMapper = session.getMapper(EmpMapper.class);

            Emp emp = empMapper.getEmp(7788);

            System.out.println(emp);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
