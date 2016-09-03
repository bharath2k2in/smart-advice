package be.ing.cts.hackathon.smart_advice;

import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("rest")
public class ApplicationConfig extends Application {

  @Override
  public Set<Class<?>> getClasses() {
    Set<Class<?>> resources = new java.util.HashSet<>();
    resources.add(SmartAdviceREST.class);
    return resources;
  }
}
