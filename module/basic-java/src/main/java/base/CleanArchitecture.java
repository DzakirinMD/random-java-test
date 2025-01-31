package base;

/**
 * <a href="https://medium.com/swlh/clean-architecture-java-spring-fea51e26e00">Clean Architecture with Coding</a>
 *
 * The idea of Clean Architecture is to put delivery and gateway at the edges of our design.
 * Business logic should not depend on whether we expose a REST or a GraphQL API, and it should not depend
 * on where we get data from — a database, a microservice API exposed via gRPC or REST, or just a simple CSV file.
 *
 * The pattern allows us to isolate the core logic of our application from OUTSIDE CONCERNS.
 * Having our core logic isolated means we can easily change data source details without a significant
 * impact or major code rewrites to the codebase.
 */

public class CleanArchitecture {
}
