package mx.com.gm.config.Jpa;

import java.lang.annotation.Annotation;
import org.springframework.boot.autoconfigure.data.AbstractRepositoryConfigurationSourceSupport;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.config.RepositoryConfigurationExtension;

public class JpaRepositoriesRegistrar extends AbstractRepositoryConfigurationSourceSupport {
    /**
     * The Spring Data annotation used to enable the particular repository support.
     *
     * @return the annotation class
     */
    @Override
    protected Class<? extends Annotation> getAnnotation() {
        return null;
    }

    /**
     * The configuration class that will be used by Spring Boot as a template.
     *
     * @return the configuration class
     */
    @Override
    protected Class<?> getConfiguration() {
        return null;
    }

    /**
     * The {@link RepositoryConfigurationExtension} for the particular repository support.
     *
     * @return the repository configuration extension
     */
    @Override
    protected RepositoryConfigurationExtension getRepositoryConfigurationExtension() {
        return null;
    }

    @EnableJpaRepositories
    private static final class EnableJpaRepositoriesConfiguration {

    }
}
