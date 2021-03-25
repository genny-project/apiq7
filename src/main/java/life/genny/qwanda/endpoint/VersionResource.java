package life.genny.qwanda.endpoint;



import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.logging.Logger;

import life.genny.qwandautils.GitUtils;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.Properties;





/**
 * Version endpoint
 *
 * @author Adam Crow
 */

@Path("/version")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VersionResource {

	private static final Logger log = Logger.getLogger(MethodHandles.lookup().lookupClass().getCanonicalName());

  
  public static final String GIT_VERSION_PROPERTIES = "GitVersion.properties";
  
  public static final String PROJECT_DEPENDENCIES = "project_dependencies";
  
  @GET
  @Path("/")
  public Response version() {
    Properties properties = new Properties();
    String versionString = "";
    try {
      properties.load(Thread.currentThread().getContextClassLoader().getResource(GIT_VERSION_PROPERTIES)
          .openStream());
      String projectDependencies = properties.getProperty(PROJECT_DEPENDENCIES);
      versionString = GitUtils.getGitVersionString(projectDependencies);
    } catch (IOException e) {
      log.error("Error reading GitVersion.properties", e);
    }

    return Response.status(200).entity(versionString).build();
  }



}
