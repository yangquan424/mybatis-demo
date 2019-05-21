import com.cheer.mybatis.Util.MybatisUtils;
import com.cheer.mybatis.dao.EmpMapper;
import com.cheer.mybatis.model.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class EmpMapperTest {
    @Test
    public void getEmp() {
        SqlSession session = MybatisUtils.getSession();

        EmpMapper empMapper = session.getMapper(EmpMapper.class);

        System.out.println(empMapper.getEmp(7788)  );

        MybatisUtils.close(session);
    }

    @Test
    public void insert() {
        String resource = "mybatis_config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = sqlSessionFactory.openSession();

            EmpMapper empMapper = session.getMapper(EmpMapper.class);
            Emp emp =new Emp();
            emp.setEmpno(1113);
            emp.setEname("yash");
            emp.setDeptno(20);

            System.out.println(empMapper.insert(emp));
            session.commit();
            session.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void getEmpAll(){
        String resource = "mybatis_config.xml";
        InputStream inputStream = null;

        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = sqlSessionFactory.openSession();

            EmpMapper empMapper = session.getMapper(EmpMapper.class);

            List<Emp> list = empMapper.getEmpAll();
            for(Emp l:list){
                System.out.println(l);
            }
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {

                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void doDelete(){
        String resource = "mybatis_config.xml";
        InputStream inputStream = null;
        try {
            //导入 mybatis的配置文件,地址“mybatis_config.xml”
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = sqlSessionFactory.openSession();

            EmpMapper empMapper = session.getMapper(EmpMapper.class);

            Emp emp = new Emp();
            emp.setEmpno(1111);

            System.out.println(empMapper.doDelete(emp));
            session.commit();;
            session.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void doUpdate(){
        String resource = "mybatis_config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = sqlSessionFactory.openSession();

            EmpMapper empMapper = session.getMapper(EmpMapper.class);
            Emp emp =new Emp();
            emp.setEmpno(1211);
            emp.setEname("yash");
            emp.setDeptno(20);

            System.out.println(empMapper.doUpdate(emp));
            session.commit();
            session.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
