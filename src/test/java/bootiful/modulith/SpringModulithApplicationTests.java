package bootiful.modulith;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModule;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class SpringModulithApplicationTests {

  @Test
  void contextLoads() {

    var modules = ApplicationModules.of(SpringModulithApplication.class);
    for (ApplicationModule module : modules) {
      System.out.println("module: " + module.getName() + ":" + module.getBasePackage());
    }
    // TODO moduleの最上位の階層のみ他のmoduleから参照できる
    //  サブパッケージを参照するとテストが失敗する
    modules.verify();

    new Documenter(modules)
        .writeIndividualModulesAsPlantUml()
        .writeModulesAsPlantUml();
  }

}
