package com.baiHoo.utils.generate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import com.baiHoo.activiti.application.vo.ApplicationModel;

@SuppressWarnings("all")
public class GeneratorUtil {
	private Class clazz;
	private String Name ;							
	private String n ;							
	private String name ;						
	private String pkg ;						//com.baiHoo.erp.auth.name
	private String dir ;						//com/baiHoo/erp/auth/name/vo
	
	public static void main(String[] args) throws Exception {
		//UserModel,TemplateModel,ApproveInfoModel
		new  GeneratorUtil(ApplicationModel.class) ;
		System.out.println("struts.xml未进行映射");
		System.out.println("HbmXml未添加关联关系");
		System.out.println("QueryModel未添加自定义范围查询条件");
		System.out.println("DaoImpl中未对自定义查询条件形式条件设置");
	}
	
	public GeneratorUtil(Class clazz) throws Exception{
		this.clazz = clazz;
		//生成所有的内容
		
		//-1.数据初始化
		dataInit();
		//0.创建目录
		generatorDirectory();
		//1.QueryModel
		generatorQueryModel();
		//2.Hbm.xml
		generatorHbmXml();
		//3.Dao
		generatorDao();
		//4.Impl
		generatorImpl();
		//5.Eb0
		generatorEbo();
		//6.Ebi
		generatorEbi();
		//7.Action
		generatorAction();
		
		//8.applicationContext.xml
		generatorApplicationContextXml();
	}
	//8.applicationContext.xml
	private void generatorApplicationContextXml() throws Exception {
		File f = new File("resources/applicationContext-"+Name+"Model.xml");
		if(f.exists()){
			return;
		}
		f.createNewFile();
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		
		bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		bw.newLine();
		
		bw.write("<beans xmlns=\"http://www.springframework.org/schema/beans\"");
		bw.newLine();
		
		bw.write("	xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
		bw.newLine();
		
		bw.write("	xsi:schemaLocation=\"");
		bw.newLine();
		
		bw.write("		http://www.springframework.org/schema/beans ");
		bw.newLine();
		
		bw.write("		http://www.springframework.org/schema/beans/spring-beans.xsd");
		bw.newLine();
		
		bw.write("		\"> ");
		bw.newLine();
		
		bw.write("	<!-- Action -->");
		bw.newLine();
		
		bw.write("	<bean id=\""+name+"Action\" class=\""+pkg+".actionWeb."+Name+"Action\" scope=\"prototype\">");
		bw.newLine();
		
		bw.write("		<property name=\""+name+"Ebo\" ref=\""+name+"Ebo\"/>");
		bw.newLine();
		
		bw.write("	</bean>");
		bw.newLine();
		
		bw.write("	<!-- Ebo -->");
		bw.newLine();
		
		bw.write("	<bean id=\""+name+"Ebo\" class=\""+pkg+".business.ebi."+Name+"Ebi\">");
		bw.newLine();
		
		bw.write("		<property name=\""+name+"Dao\" ref=\""+name+"Dao\"/>");
		bw.newLine();
		
		bw.write("	</bean>");
		bw.newLine();
		
		bw.write("	<!-- Dao -->");
		bw.newLine();
		
		bw.write("	<bean id=\""+name+"Dao\" class=\""+pkg+".dao.impl."+Name+"Impl\">");
		bw.newLine();
		
		bw.write("		<property name=\"sessionFactory\" ref=\"sessionFactory\"/>");
		bw.newLine();
		
		bw.write("	</bean>");
		bw.newLine();
		
		bw.write("</beans>");
		bw.newLine();
		
		bw.flush();
		bw.close();			
	}

	//7.Action
	private void generatorAction() throws Exception {
		File f = new File("src/"+dir+"/actionWeb/"+Name+"Action.java");
		if(f.exists()){
			return;
		}
		f.createNewFile();
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		
		bw.write("package "+pkg+".actionWeb;");
		bw.newLine();
		
		bw.newLine();
		
		bw.write("import java.util.List;");
		bw.newLine();
		
		bw.newLine();
		
		bw.write("import "+pkg+".business.ebo."+Name+"Ebo;");
		bw.newLine();
		
		bw.write("import "+pkg+".vo."+Name+"Model;");
		bw.newLine();
		
		bw.write("import "+pkg+".vo."+Name+"QueryModel;");
		bw.newLine();
		
		bw.write("import com.baiHoo.utils.base.BaseAction;");
		bw.newLine();
		
		bw.newLine();
		
		bw.write("public class "+Name+"Action extends BaseAction{");
		bw.newLine();
		
		bw.write("	public "+Name+"Model "+n+"m = new "+Name+"Model();");
		bw.newLine();
		
		bw.write("	public "+Name+"QueryModel "+n+"qm = new "+Name+"QueryModel();");
		bw.newLine();
		
		bw.newLine();
		
		bw.write("	private "+Name+"Ebo "+name+"Ebo;");
		bw.newLine();
		
		bw.write("	public void set"+Name+"Ebo("+Name+"Ebo "+name+"Ebo) {");
		bw.newLine();
		
		bw.write("		this."+name+"Ebo = "+name+"Ebo;");
		bw.newLine();
		
		bw.write("	}");
		bw.newLine();
		
		bw.newLine();
		
		bw.write("	//列表");
		bw.newLine();
		
		bw.write("	public String list(){");
		bw.newLine();
		
		bw.write("		setTotalData("+name+"Ebo.getCount("+n+"qm));");
		bw.newLine();
		
		bw.write("		List<"+Name+"Model> "+name+"List = "+name+"Ebo.getAll("+n+"qm, currentPage, pageDataCount);");
		bw.newLine();
		
		bw.write("		put(\""+name+"List\", "+name+"List);");
		bw.newLine();
		
		bw.write("		return LIST;");
		bw.newLine();
		
		bw.write("	}");
		bw.newLine();
		
		bw.newLine();
		
		bw.write("	//到添加");
		bw.newLine();
		
		bw.write("	public String input(){");
		bw.newLine();
		
		bw.write("		if("+n+"m.getUuid()!=null){");
		bw.newLine();
		
		bw.write("			"+n+"m = "+name+"Ebo.get("+n+"m.getUuid());");
		bw.newLine();
		
		bw.write("		}");
		bw.newLine();
		
		bw.write("		return INPUT;");
		bw.newLine();
		
		bw.write("	}");
		bw.newLine();
		
		bw.newLine();
		
		bw.write("	//添加");
		bw.newLine();
		
		bw.write("	public String save(){");
		bw.newLine();
		
		bw.write("		if("+n+"m.getUuid() == null){");
		bw.newLine();
		
		bw.write("			"+name+"Ebo.save("+n+"m);");
		bw.newLine();
		
		bw.write("		}else{");
		bw.newLine();
		
		bw.write("			"+name+"Ebo.update("+n+"m);");
		bw.newLine();
		
		bw.write("		}");
		bw.newLine();
		
		bw.write("		return TO_LIST;");
		bw.newLine();
		
		bw.write("	}");
		bw.newLine();
		
		bw.newLine();
		
		bw.write("	//删除");
		bw.newLine();
		
		bw.write("	public String delete(){");
		bw.newLine();
		
		bw.write("		"+name+"Ebo.delete("+n+"m);");
		bw.newLine();
		
		bw.write("		return TO_LIST;");
		bw.newLine();
		
		bw.write("	}");
		bw.newLine();
		
		bw.newLine();
		
		bw.write("}");
		bw.newLine();

		bw.flush();
		bw.close();			
	}

	//6.Ebi
	private void generatorEbi()  throws Exception {
		File f = new File("src/"+dir+"/business/ebi/"+Name+"Ebi.java");
		if(f.exists()){
			return;
		}
		f.createNewFile();
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		
		bw.write("package "+pkg+".business.ebi;");
		bw.newLine();
		
		bw.newLine();
		
		bw.write("import java.io.Serializable;");
		bw.newLine();
		
		bw.write("import java.util.List;");
		bw.newLine();
		
		bw.newLine();
		
		bw.write("import "+pkg+".business.ebo."+Name+"Ebo;");
		bw.newLine();
		
		bw.write("import "+pkg+".dao.dao."+Name+"Dao;");
		bw.newLine();
		
		bw.write("import "+pkg+".vo."+Name+"Model;");
		bw.newLine();
		
		bw.write("import com.baiHoo.utils.base.BaseQueryModel;");
		bw.newLine();
		
		bw.newLine();
		
		bw.write("public class "+Name+"Ebi implements "+Name+"Ebo{");
		bw.newLine();
		
		bw.write("	private "+Name+"Dao "+name+"Dao;");
		bw.newLine();
		
		bw.write("	public void set"+Name+"Dao("+Name+"Dao "+name+"Dao) {");
		bw.newLine();
		
		bw.write("		this."+name+"Dao = "+name+"Dao;");
		bw.newLine();
		
		bw.write("	}");
		bw.newLine();
		
		bw.newLine();
		
		bw.write("	public void save("+Name+"Model "+n+"m) {");
		bw.newLine();
		
		bw.write("		"+name+"Dao.save("+n+"m);");
		bw.newLine();
		
		bw.write("	}");
		bw.newLine();
		
		bw.newLine();
		
		bw.write("	public void update("+Name+"Model "+n+"m) {");
		bw.newLine();
		
		bw.write("		"+name+"Dao.update("+n+"m);");
		bw.newLine();
		
		bw.write("	}");
		bw.newLine();
		
		bw.newLine();
		
		bw.write("	public void delete("+Name+"Model "+n+"m) {");
		bw.newLine();
		
		bw.write("		"+name+"Dao.delete("+n+"m);");
		bw.newLine();
		
		bw.write("	}");
		bw.newLine();
		
		bw.newLine();
		
		bw.write("	public "+Name+"Model get(Serializable uuid) {");
		bw.newLine();
		
		bw.write("		return "+name+"Dao.get(uuid);");
		bw.newLine();
		
		bw.write("	}");
		bw.newLine();
		
		bw.newLine();
		
		bw.write("	public List<"+Name+"Model> getAll() {");
		bw.newLine();
		
		bw.write("		return "+name+"Dao.getAll();");
		bw.newLine();
		
		bw.write("	}");
		bw.newLine();
		
		bw.newLine();
		
		bw.write("	public List<"+Name+"Model> getAll(BaseQueryModel qm, Integer currentPage,Integer pageDataCount) {");
		bw.newLine();
		
		bw.write("		return "+name+"Dao.getAll(qm, currentPage, pageDataCount);");
		bw.newLine();
		
		bw.write("	}");
		bw.newLine();
		
		bw.newLine();
		
		bw.write("	public Integer getCount(BaseQueryModel qm) {");
		bw.newLine();
		
		bw.write("		return "+name+"Dao.getCount(qm);");
		bw.newLine();
		
		bw.write("	}");
		bw.newLine();
		
		bw.newLine();
		
		bw.write("}");
		bw.newLine();
		
		bw.flush();
		bw.close();			
	}

	//5.Ebo
	private void generatorEbo()  throws Exception {
		File f = new File("src/"+dir+"/business/ebo/"+Name+"Ebo.java");
		if(f.exists()){
			return;
		}
		f.createNewFile();
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		
		bw.write("package "+pkg+".business.ebo;");
		bw.newLine();
		
		bw.newLine();
		
		bw.write("import org.springframework.transaction.annotation.Transactional;");
		bw.newLine();
		
		bw.newLine();
		
		bw.write("import "+pkg+".vo."+Name+"Model;");
		bw.newLine();
		
		bw.write("import com.baiHoo.utils.base.BaseEbo;");
		bw.newLine();
		
		bw.newLine();
		
		bw.write("@Transactional");
		bw.newLine();
		
		bw.write("public interface "+Name+"Ebo extends BaseEbo<"+Name+"Model>{");
		bw.newLine();
		
		bw.newLine();
		
		bw.write("}");
		bw.newLine();
		
		bw.flush();
		bw.close();	
	}

	//4.Impl
	private void generatorImpl()  throws Exception {
		File f = new File("src/"+dir+"/dao/impl/"+Name+"Impl.java");
		if(f.exists()){
			return;
		}
		f.createNewFile();
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		
		bw.write("package "+pkg+".dao.impl;");
		bw.newLine();
		
		bw.newLine();
		
		bw.write("import org.hibernate.criterion.DetachedCriteria;");
		bw.newLine();

		bw.write("import org.hibernate.criterion.Restrictions;");
		bw.newLine();

		bw.newLine();
		
		bw.write("import "+pkg+".dao.dao."+Name+"Dao;");
		bw.newLine();
		
		bw.write("import "+pkg+".vo."+Name+"Model;");
		bw.newLine();
		
		bw.write("import "+pkg+".vo."+Name+"QueryModel;");
		bw.newLine();
		
		bw.write("import com.baiHoo.utils.base.BaseImpl;");
		bw.newLine();
		
		bw.write("import com.baiHoo.utils.base.BaseQueryModel;");
		bw.newLine();
		
		bw.newLine();
		
		bw.write("public class "+Name+"Impl extends BaseImpl<"+Name+"Model> implements "+Name+"Dao{");
		bw.newLine();
		
		bw.newLine();
		
		bw.write("	public void doQueryDetachedCriteria(DetachedCriteria dc,BaseQueryModel qm){");
		bw.newLine();
		
		bw.write("		"+Name+"QueryModel "+n+"qm = ("+Name+"QueryModel)qm;");
		bw.newLine();
		
		bw.write("		// TODO 添加自定义查询条件");
		bw.newLine();
		
		bw.write("	}");
		bw.newLine();
		
		bw.newLine();
		
		bw.write("}");
		bw.newLine();
		
		bw.flush();
		bw.close();		
	}

	//3.Dao
	private void generatorDao() throws Exception {
		File f = new File("src/"+dir+"/dao/dao/"+Name+"Dao.java");
		if(f.exists()){
			return;
		}
		f.createNewFile();
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		
		bw.write("package "+pkg+".dao.dao;");
		bw.newLine();
		
		bw.newLine();
		
		bw.write("import "+pkg+".vo."+Name+"Model;");
		bw.newLine();
		
		bw.write("import com.baiHoo.utils.base.BaseDao;");
		bw.newLine();
		
		bw.newLine();
		
		bw.write("public interface "+Name+"Dao extends BaseDao<"+Name+"Model> {");
		bw.newLine();
		
		bw.newLine();
		
		bw.write("}");
		bw.newLine();
		
		bw.flush();
		bw.close();		
	}

	//2.Hbm.xml
	private void generatorHbmXml() throws Exception {
		//1.创建文件
		File f = new File("src/"+dir+"/vo/"+Name+"Model.hbm.xml");
		
		if(f.exists()){
			return;
		}
		
		f.createNewFile();
		//2.IO写入内容
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		
		bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		bw.newLine();
		
		bw.write("<!DOCTYPE hibernate-mapping PUBLIC");
		bw.newLine();
		
		bw.write("        '-//Hibernate/Hibernate Mapping DTD 3.0//EN'");
		bw.newLine();
		
		bw.write("        'http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd'>");
		bw.newLine();
		
		bw.write("<hibernate-mapping>");
		bw.newLine();
		
		bw.write("    <class name=\""+pkg+".vo."+Name+"Model\" table=\"table_"+Name+"\">");
		bw.newLine();
		
		bw.write("        <id name=\"uuid\">");
		bw.newLine();
		
		bw.write("            <generator class=\"native\" />");
		bw.newLine();
		
		bw.write("        </id>");
		bw.newLine();
		
		//hibernate的映射配置文件中要对原始模型类中的属性进行配置，反射获取所有字段
		Field[] fds = clazz.getDeclaredFields();
		for(Field fd:fds) {
			//如果字段的修饰符是private，生成
			if(fd.getModifiers() == Modifier.PRIVATE && !fd.getName().equals("uuid")){
				//如果是关联关系不生成,不是关联关系(Long,Integer,Double,String)
				if( fd.getType().equals(String.class)||
					fd.getType().equals(Long.class)||
					fd.getType().equals(Integer.class)||
					fd.getType().equals(Double.class)
					){
					if(!fd.getName().endsWith("View")){
						bw.write("        <property name=\""+fd.getName()+"\"/>");
						bw.newLine();
					}
				}
			}
		}
		
		bw.write("    </class>");
		bw.newLine();
		
		bw.write("</hibernate-mapping>");
		bw.newLine();
		
		bw.flush();
		bw.close();		
	}

	//1.NameQueryModel
	private void generatorQueryModel() throws Exception {
		//1.创建文件
		File f = new File("src/"+dir+"/vo/"+Name+"QueryModel.java");
		
		//判断：如果该文件存在，终止操作
		if(f.exists()){
			return;
		}
		
		f.createNewFile();
		//2.IO写入内容
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		
		bw.write("package "+pkg+".vo;");
		bw.newLine();
		
		bw.newLine();
		
		bw.write("import com.baiHoo.utils.base.BaseQueryModel;");
		bw.newLine();
		
		bw.newLine();
		
		bw.write("public class "+Name+"QueryModel extends "+Name+"Model implements BaseQueryModel{");
		bw.newLine();
		
		bw.write("	// TODO 添加自定义查询条件");
		bw.newLine();
		
		bw.write("}");
		bw.newLine();
		
		bw.flush();
		bw.close();
	}
	
	//0.创建目录
	private void generatorDirectory() {
		//business/ebi
		//				 src+//com.baiHoo.erp.auth.emp+business/ebi .vo
		File f = new File("src/"+dir+"/business/ebi");
		f.mkdirs();
		//business/ebo
		f = new File("src/"+dir+"/business/ebo");
		f.mkdirs();
		//dao/dao
		f = new File("src/"+dir+"/dao/dao");
		f.mkdirs();
		//dao/impl
		f = new File("src/"+dir+"/dao/impl");
		f.mkdirs();
		//web
		f = new File("src/"+dir+"/actionWeb");
		f.mkdirs();
	}
	
	//-1.数据初始化
	private void dataInit() {
		String NameModel = clazz.getSimpleName();						//NameModel
		Name = NameModel.substring(0, NameModel.length()-5);				//name
		String first = Name.substring(0,1);												//N
		n = Name.substring(0,1).toLowerCase();											//n
		name =n+Name.substring(1);																	//name
		String rootPkg = clazz.getPackage().getName();					//com.baiHoo.erp.auth.name.vo
		pkg = rootPkg.substring(0,rootPkg.length()-3);						//com.baiHoo.erp.auth.name
		dir = pkg.replace(".","/");															//com/baiHoo/erp/auth/name/vo
	}
	
}
