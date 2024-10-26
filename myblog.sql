create database if not exists huihui;
use huihui;

create table articles
(
    id           int auto_increment
        primary key,
    excerpt      varchar(500) null,
    full_content text         null,
    title        varchar(100) null,
    image        varchar(200) null
);

create table contact
(
    id           int auto_increment
        primary key,
    name         varchar(100)                       null,
    email        varchar(100)                       null,
    message      varchar(500)                       null,
    created_time datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP
);

create table contactmethods
(
    name  varchar(100) null,
    value varchar(100) null,
    icon  varchar(100) null,
    id    int auto_increment
        primary key
);

create table earnedbadges
(
    id   int auto_increment
        primary key,
    name varchar(100) null,
    icon varchar(100) null,
    url  varchar(200) null
);

create table enitem_data
(
    item_id      int auto_increment
        primary key,
    image        varchar(200)  null,
    description  varchar(500)  null,
    video        varchar(200)  null,
    video_poster varchar(200)  null,
    en_id        int           null,
    excerpt      varchar(500)  null,
    content      varchar(3000) null,
    title        varchar(200)  null,
    item_name    varchar(200)  null
);

create table entertainment
(
    en_id       int auto_increment
        primary key,
    title       varchar(100) null,
    icon        varchar(100) null,
    items       varchar(100) null,
    description varchar(500) null,
    image       varchar(200) null,
    article_id  int          null
);

create table experiences
(
    ex_id               int auto_increment
        primary key,
    title               varchar(100)  null,
    description         varchar(1000) null,
    year                varchar(50)   null,
    image               varchar(100)  null,
    skills              varchar(500)  null,
    challenges_overcome varchar(500)  null,
    key_achievements    varchar(500)  null
);

create table learning
(
    le_id           int auto_increment
        primary key,
    title           varchar(100) null,
    description     varchar(500) null,
    icon            varchar(100) null,
    color           varchar(100) null,
    progress        int          null,
    fulldescription varchar(500) null,
    skills          varchar(500) null
);

create table life
(
    li_id       int auto_increment
        primary key,
    title       varchar(100) null,
    description varchar(500) null,
    image       varchar(200) null
);

create table lifecontents
(
    id               int auto_increment
        primary key,
    title            varchar(100)  null,
    description      varchar(500)  null,
    image            varchar(200)  null,
    full_description varchar(2000) null,
    li_id            int           not null
);

create table music
(
    id          int auto_increment
        primary key,
    title       varchar(100) null,
    artist      varchar(100) null,
    cover       varchar(200) null,
    genre       varchar(100) null,
    is_favorite tinyint(1)   null,
    audio       varchar(200) null
);

create table resources
(
    re_id int auto_increment
        primary key,
    name  varchar(100) null,
    url   varchar(100) null,
    icon  varchar(100) null,
    le_id int          not null
);

create table social
(
    id   int auto_increment
        primary key,
    name varchar(100) null,
    url  varchar(200) null,
    icon varchar(100) null
);

create table timeline
(
    time_id     int auto_increment
        primary key,
    title       varchar(100) null,
    description varchar(500) null,
    date        varchar(100) null
);

create table wheelItems
(
    image  varchar(2000) null,
    limage varchar(100)  null,
    rimage varchar(100)  null,
    name   varchar(100)  null,
    intro  varchar(200)  null,
    id     int auto_increment
        primary key
)
    comment '轮播图';

INSERT INTO huihui.articles (id, excerpt, full_content, title, image) VALUES (1, 'java也可以结合AI？| springboot集成chatGLM', '<body>
    <div class="container">
        <h2>什么是GLM：</h2>

        <p>GLM 全名 General Language Model，是一款基于自回归填空的预训练语言模型。ChatGLM 系列模型，支持相对复杂的自然语言指令，并且能够解决困难的推理类问题。该模型配备了易于使用的 API 接口，允许开发者轻松将其融入各类应用，广泛应用于智能客服、虚拟主播、聊天机器人等诸多领域。</p>

        <h2>SDK 安装说明</h2>
        <p>安装 Java SDK</p>
        <p>Java SDK 地址： <a href="https://github.com/zhipuai/zhipuai-sdk-java-v4">https://github.com/zhipuai/zhipuai-sdk-java-v4</a></p>
        <p>将SDK的依赖项加入到Maven项目：</p>

        <h2>Java SDK 创建 Client</h2>
        <p>使用 Java SDK 您替换自己的 ApiSecretKey 即可，示例如下：</p>
        <pre><code>ClientV4 client = new ClientV4.Builder("{Your ApiSecretKey}").build();</code></pre>

        <p>传输层默认使用 okhttpclient，如果需要修改为其他 http client，可以如下指定（注意 apache不支持sse调用）：</p>
        <pre><code>ClientV4 client = new ClientV4.Builder("{Your ApiSecretKey}")
                  .httpTransport(new ApacheHttpClientTransport())
                  .build();</code></pre>

        <h2>SDK 代码示例</h2>

        <h2>同步调用</h2>
        <p>调用后即可一次性获得最终结果,Java 代码如下：</p>
        <pre><code>/**
 * 同步调用
 */<br>private static void testInvoke() {<br>   List&lt;ChatMessage&gt; messages = new ArrayList&lt;&gt;();<br>
  ChatMessage chatMessage = new ChatMessage(ChatMessageRole.USER.value(), <br> "作为一名营销专家，请为智谱开放平台创作一个吸引人的slogan");
  <br>  messages.add(chatMessage);<br>  String requestId = String.format(requestIdTemplate, System.currentTimeMillis());<br>
  <br>  ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest.builder()<br>
      .model(Constants.ModelChatGLM4)<br>           .stream(Boolean.FALSE)<br>
        .invokeMethod(Constants.invokeMethod)<br>           .messages(messages)<br>           .requestId(requestId)<br>           .build();<br>  ModelApiResponse invokeModelApiResp = client.invokeModelApi(chatCompletionRequest);<br>  try {<br>       System.out.println("model output:" + mapper.writeValueAsString(invokeModelApiResp));<br>  } catch (JsonProcessingException e) {<br>       e.printStackTrace();<br>  }<br>}</code></pre>

        <h2>异步调用</h2>
        <p>调用后会立即返回一个任务 ID，然后用任务ID查询调用结果（根据模型和参数的不同，通常需要等待10-30秒才能得到最终结果）</p>
        <pre><code>/**
 * 异步调用
 */<br>private static String testAsyncInvoke() {<br>   List&lt;ChatMessage&gt; messages = new ArrayList&lt;&gt;();
 <br>  ChatMessage chatMessage = new ChatMessage(ChatMessageRole.USER.value(), <br> "作为一名营销专家，请为智谱开放平台创作一个吸引人的slogan");<br>  messages.add(chatMessage);<br>  String requestId = String.format(requestIdTemplate, System.currentTimeMillis());<br><br>  ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest.builder()<br>           .model(Constants.ModelChatGLM4)<br>           .stream(Boolean.FALSE)<br>           .invokeMethod(Constants.invokeMethodAsync)<br>           .messages(messages)<br>           .requestId(requestId)<br>           .build();<br>  ModelApiResponse invokeModelApiResp = client.invokeModelApi(chatCompletionRequest);<br>  System.out.println("model output:" + JSON.toJSONString(invokeModelApiResp));<br>  return invokeModelApiResp.getData().getTaskId();<br>}</code></pre>

        <h2>SSE 调用</h2>
        <p>调用后可以流式的实时获取到结果直到结束</p>
        <pre><code>private static void testSseInvoke() {<br>   List&lt;ChatMessage&gt; messages = new ArrayList&lt;&gt;();<br>
          ChatMessage chatMessage = new ChatMessage(ChatMessageRole.USER.value(), <br> "作为一名营销专家，请为智谱开放平台创作一个吸引人的slogan");<br>  messages.add(chatMessage);<br>  String requestId = String.format(requestIdTemplate, System.currentTimeMillis());<br><br>  ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest.builder()<br>           .model(Constants.ModelChatGLM4)<br>           .stream(Boolean.TRUE)<br>           .messages(messages)<br>           .requestId(requestId)<br>           .build();<br>  ModelApiResponse sseModelApiResp = client.invokeModelApi(chatCompletionRequest);<br>  if (sseModelApiResp.isSuccess()) {<br>       AtomicBoolean isFirst = new AtomicBoolean(true);<br>       ChatMessageAccumulator chatMessageAccumulator = mapStreamToAccumulator(sseModelApiResp.getFlowable())<br>               .doOnNext(accumulator -&gt; {<br>                  {<br>                       if (isFirst.getAndSet(false)) {<br>                           System.out.print("Response: ");<br>                       }<br>                       if (accumulator.getDelta() != null &amp;&amp; accumulator.getDelta().getTool_calls() != null) {<br>                           String jsonString = mapper.writeValueAsString(accumulator.getDelta().getTool_calls());<br>                           System.out.println("tool_calls: " + jsonString);<br>                       }<br>                       if (accumulator.getDelta() != null &amp;&amp; accumulator.getDelta().getContent() != null) {<br>                           System.out.print(accumulator.getDelta().getContent());<br>                       }<br>                  }<br>               })
               .doOnComplete(System.out::println)
               .lastElement()
               .blockingGet();

       Choice choice = new Choice(chatMessageAccumulator.getChoice().getFinishReason(), 0L, chatMessageAccumulator.getDelta());
       List&lt;Choice&gt; choices = new ArrayList&lt;&gt;();
       choices.add(choice);
       ModelData data = new ModelData();
       data.setChoices(choices);
       data.setUsage(chatMessageAccumulator.getUsage());
       data.setId(chatMessageAccumulator.getId());
       data.setCreated(chatMessageAccumulator.getCreated());
       data.setRequestId(chatCompletionRequest.getRequestId());
       sseModelApiResp.setFlowable(null);
       sseModelApiResp.setData(data);
   }
   System.out.println("model output:" + JSON.toJSONString(sseModelApiResp));<br>}</code></pre>

        <h2>springboot整合chatGLM</h2>

        <h3>智谱清言Controller类</h3>
        <pre><code>@GetMapping("/chatTo")<br>public ResponseEntity&lt;String&gt; chatTo(@RequestParam String message)
        {<br>    System.out.println("Message: " + message);<br>    String response = openAiService.generateTo(message);<br>    System.out.println(response);<br>    return ResponseEntity.ok(response);<br>}</code></pre>

        <h3>智谱清言实现类</h3>
        <pre><code>@Service
@Slf4j
public class OpenAiServiceImpl implements OpenAiService {
    private static final ClientV4 client = new ClientV4.Builder("vv.vv").build();
    private static final ObjectMapper mapper = defaultObjectMapper();
    public static ObjectMapper defaultObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        mapper.addMixIn(ChatFunction.class, ChatFunctionMixIn.class);
        mapper.addMixIn(ChatCompletionRequest.class, ChatCompletionRequestMixIn.class);
        mapper.addMixIn(ChatFunctionCall.class, ChatFunctionCallMixIn.class);
        return mapper;
    }
    @Override
    public String generate(String message) {
        ClientV4 client = new ClientV4.Builder("vv.vv").build();
        List&lt;ChatMessage&gt; messages = new ArrayList&lt;&gt;();
        ChatMessage chatMessage = newChatMessage(ChatMessageRole.USER.value(), message);
         messages.add(chatMessage);
         messages.         String requestIdTemplate          String requestId = String.format(requestIdTemplate, System.curr         ChatCompletionRequest chatCompletionRequest = ChatCompletion                 .model(Constan                 .stre                 .invokeMethod(Constants.i                 .m                 .req                  ModelApiResponse invokeModelApiResp = client.invokeModelApi(chatCo         System.out.println("model output:" + JSON.toJSONString(invo         String taskId = invokeModelApiResp.getDa         System.out         String apiKey = "vv.v         String apiUrl = "https://api.zhipu.ai/v4/queryTaskResult";          StringBuilder response = new             URL url = new URL(apiUrl + "?ta             HttpURLConnection connection = (HttpURLConnection) url.             connection.setRequestProperty("Authorization", "Be             connection.setRequestProperty("Content-Type", "ap             connection.setRequ             int responseCode = connection.g             System.out.println("Response Code: "             BufferedReader in = new BufferedReader(new InputStreamReader(connection.ge                          while ((inputLine = in.readL                 response.a                    System.out.println("Response: " + resp         } catc             e.p         return res     public String generateTo(         List<ChatMessage> messages = n         ChatMessage chatMessage = new ChatMessage(ChatMessageRole.USER.v         messages.         String requestIdTemplate = "request         String requestId = String.format(requestIdTemplate, System.curr              List<ChatTool> chatToolList = n         ChatTool chatTool          chatTool.setType(ChatToolType.F         ChatFunctionParameters chatFunctionParameters = new ChatFunc         chatFunctionParameters.s         Map<String, Object> properties =         properties.put("location", new HashMap<Str             put("             put("descript         properties.put("unit", new HashMap<Str             put("             put("enum", new Array                                a         chatFunctionParameters.setProper         ChatFunction chatFunction = ChatF                 .na                 .description("Get the current weathe                 .parameters(chatFu                  chatTool.setFuncti         chatToolLi         ChatCompletionRequest chatCompletionRequest = ChatCompletion                 .model(Constan                 .stre                 .invokeMethod(Consta                 .m                 .req                 .to                 .t                  ModelApiResponse invokeModelApiResp = client.invokeModelApi(chatCo             System.out.println("model output:" + mapper.writeValueAsString(invo         } catch (JsonProcess             e.p         return invokeModelApiResp.getD         <h3>Service</h3>
              <pre><code>public interface OpenAiService {
          String generate(String message);
          String generateTo(String message);
      }</code></pre>

              <h3>启动类</h3>
              <pre><code>@SpringBootApplication
      @Slf4j
      @EnableTransactionManagement // 开启注解方式的事务管理
     @ServletComponentScan // 开启了对servlet组件的支持
     public class XxxxxxxxApplication {
         public static void main(String[] args) {
             SpringApplication.run(XxxxxApplication.class, args);
             log.info("server started");
         }
     }</code></pre>
         </div>
                   ', 'springboot集成chatGLM', 'https://wlmtsys.com:9000/huihui/ZHIPU.jpg');
INSERT INTO huihui.articles (id, excerpt, full_content, title, image) VALUES (2, 'java集合面试题', '<h1>Java 中有哪些集合类？请简单介绍</h1>
<ul>
<li>List：有序集合，允许重复元素，如 ArrayList 和 LinkedList。</li>
<li>Set：无序集合，不允许重复元素，如 HashSet、LinkedHashSet 和 TreeSet。</li>
<li>Map：键值对集合，如 HashMap、LinkedHashMap 和 TreeMap。</li>
<li>Queue 和 Deque：队列和双端队列，用于元素的顺序处理，如 LinkedList 和 ArrayDeque。</li>
<li>Stack：栈，后进先出（LIFO）结构，通常使用 ArrayDeque 或 LinkedList 实现。</li>
<li>Collections：提供操作集合的静态方法，如排序。</li>
</ul>


<h1>数组和链表在 Java中的区别是什么?</h1>
内存分配<br>

数组：在创建时需要指定固定的大小，并且内存是连续分配的。这意味着数组的大小一旦确定，在运行时就不能更改。<br>

链表：不需要预先指定大小，内存分配是非连续的。链表中的每个元素（通常称为节点）包含数据和指向下一个节点的引用。<br>


数组<br>
访问：需要从头开始遍历，直到找到所需的元素，时间复杂度为 O(n)。<br>

插入/删除：可以在 O(1) 时间复杂度内完成，如果已经有一个指向要插入或删除节点的指针。<br>



链表：<br>

访问：通过索引访问元素非常快，时间复杂度为 O(1)。<br>

插入/删除：如果需要在数组中间插入或删除元素，可能需要移动大量元素以维持连续性，时间复杂度为 O(n)。<br>


使用场景<br>

数组：适用于已知元素数量和大小，且需要频繁通过索引访问元素的场景。<br>

链表：适用于元素数量频繁变动，或者需要在集合中间高效插入和删除的场景。<br>



随机访问<br>


数组：支持随机访问，即可以直接通过索引访问任意位置的元素。<br>

链表：不支持随机访问，访问特定位置的元素需要从头开始遍历。<br>



内存使用<br>

数组：除了存储元素本身，不需要额外的内存来存储指向其他元素的引用。<br>

链表：每个元素除了存储数据外，还需要额外的内存来存储指向下一个（和前一个，对于双向链表）节点的引用。<br>



实现方式<br>

数组：在 Java 中，数组是一个基本数据类型，使用固定大小的连续内存块。
<br>
链表：在 Java 中，链表是通过 LinkedList 类实现的，它是基于节点的集合，每个节点包含数据和对其他节点的引用。<br>



线程安全性
<br>
数组：不是线程安全的，需要手动同步访问。
<br>
链表：LinkedList 也不是线程安全的，同样需要手动同步访问。

<br>




<h1>Java 中的 HashSet 和 HashMap 有什么区别？</h1>


Java 中的 HashSet 和 HashMap 都是基于哈希表实现的集合类，但它们在用途和功能上有一些关键的区别：<br>

存储内容：<br>

HashSet 存储的是一组不包含重复元素的集合，只关心元素本身。<br>

HashMap 存储的是键值对（key-value pairs），每个键映射到一个值。<br>



用途：<br>

HashSet 通常用于测试一个元素是否存在于某个集合中，或者实现集合的并集、交集、差集等操作。<br>

HashMap 通常用于实现键与值的映射关系，比如缓存、数据库索引等。<br>



性能：<br>

HashSet 在添加、删除和查找元素时，性能通常接近 O(1)。
<br>
HashMap 在添加、删除和查找键值对时，性能也通常接近 O(1)，但需要考虑键的哈希值的分布。
<br>


遍历顺序：<br>

HashSet 不保证元素的遍历顺序。<br>

HashMap 也不保证键值对的遍历顺序，但可以通过 LinkedHashMap 来保持插入顺序。
<br>


Null 值：<br>

HashSet 不允许使用 null 作为元素。
<br>
HashMap 允许一个 null 键和多个 null 值。
<br>


实现：
<br>
HashSet 是基于 HashMap 实现的，它使用元素本身作为键，元素的哈希值作为键的哈希值。
<br>
HashMap 是一个独立的实现，直接存储键值对。
<br>


线程安全性：<br>

两者都不是线程安全的。如果需要线程安全，可以使用 ConcurrentHashMap 替代 HashMap，或者使用 Collections.synchronizedSet 方法包装 HashSet。
<br>


迭代器：
<br>
HashSet 提供的迭代器只能用于迭代元素。
<br>
HashMap 提供的迭代器可以迭代键（keySet()）、值（values()）或键值对（entrySet()）。
<br>


HashSet 更适合于需要快速查找和测试元素是否存在的场景，而 HashMap 更适合于需要存储和查找键值对的场景。

<br>



Java 中 HashMap
 的实现原理是什么？<br>



在 Java 中，HashMap 的实现原理主要基于哈希表。<br>

它的工作方式大致如下：<br>



哈希函数<br>

HashMap 使用一个哈希函数将键映射到数组的索引位置。哈希函数的目的是尽可能均匀地分布键，以减少冲突的可能性。


<br>
数组和链表（或红黑树）
<br>
内部使用一个数组来存储元素。当通过哈希函数计算出的索引位置相同（即发生哈希冲突）时，会以链表的形式将元素链接起来。如果链表长度超过一定阈值（默认是 8），则会将链表转换为红黑树，以提高查找效率。

<br>

负载因子和扩容<br>

HashMap 有一个负载因子（默认值是 0.75），当元素数量达到数组长度乘以负载因子时，会触发扩容操作。扩容时会创建一个更大的数组，并重新计算元素在新数组中的位置。
<br>
例如，如果您有一个 HashMap ，初始容量为 16 ，添加了 12 个元素（超过了 16 * 0.75 = 12 ），此时就会进行扩容，新的数组容量可能会变为 32 。
<br>


这种实现方式使得 HashMap 在大多数情况下能够提供高效的插入、删除和查找操作，平均时间复杂度接近 O(1) 。但在极端情况下，当哈希冲突严重时，性能可能会有所下降。
<br>
', 'java集合面试题', 'https://wlmtsys.com:9000/huihui/jihe.png');
INSERT INTO huihui.articles (id, excerpt, full_content, title, image) VALUES (3, '怎么去架构一个前后端分离的微服务项目', '架构一个前后端分离的微服务项目是一个复杂的过程，涉及到多个技术栈和设计原则。<br>以下是构建这类项目的一些关键步骤和考虑因素：

1. 需求分析和规划<br>
明确业务需求：了解项目的目标、功能需求和非功能需求。<br>
定义服务边界：根据业务需求定义微服务的边界，确定每个服务的职责。<br>
2. 技术选型<br>
选择后端技术栈：根据团队熟悉度和项目需求选择合适的编程语言和框架，如Java（Spring Boot）、Node.js（Express）、Python（Django）、Go等。<br>
选择前端技术栈：根据用户体验需求选择合适的前端框架，如React、Vue.js、Angular等。<br>
数据库选择：根据数据模型和查询需求选择合适的数据库，如MySQL、PostgreSQL、MongoDB等。<br>
消息队列：选择适合的中间件，如RabbitMQ、Kafka等，用于服务间异步通信。<br>
配置中心：用于集中管理微服务的配置信息，如Spring Cloud Config、Consul等。<br>
服务发现与注册：如Eureka、Consul、Zookeeper等。<br>
API网关：如Nginx、Zuul、Spring Cloud Gateway等，用于请求路由、负载均衡等。<br>
3. 微服务设计<br>
定义RESTful API：设计清晰的API接口，使用JSON或XML作为数据交换格式。<br>
服务间通信：定义服务间通信的协议和数据格式。<br>
数据一致性：设计事务管理和数据一致性的策略，如使用Saga模式处理分布式事务。<br>
4. 安全性设计<br>
认证与授权：实现OAuth2、JWT等认证授权机制。<br>
数据加密：确保敏感数据在传输和存储时加密。<br>
API安全：使用API网关实现限流、熔断等安全措施。<br>
5. 开发和测试<br>
持续集成/持续部署（CI/CD）：设置自动化的构建、测试和部署流程。<br>
单元测试和集成测试：编写测试代码，确保服务的稳定性和可靠性。<br>
端到端测试：模拟用户操作，测试整个应用流程。<br>
6. 监控和日志<br>
监控：使用Prometheus、Grafana等工具监控服务性能和健康状态。<br>
日志管理：使用ELK Stack（Elasticsearch、Logstash、Kibana）或类似工具集中管理日志。<br>
7. 部署<br>
容器化：使用Docker容器化服务，提高环境一致性和部署效率。<br>
容器编排：使用Kubernetes或Docker Swarm进行容器的部署和管理。<br>
服务网格：如Istio，提供更细粒度的服务间通信控制。<br>
8. 文档和维护<br>
API文档：使用Swagger等工具生成API文档。<br>
维护和更新：定期更新服务，修复漏洞，添加新功能。<br>
9. 性能优化<br>
缓存：使用Redis等缓存服务减少数据库访问。<br>
数据库优化：索引、查询优化等。<br>
负载均衡：在服务和数据库层面使用负载均衡提高性能。<br>
10. 可伸缩性和高可用性<br>
水平扩展：确保服务可以水平扩展以应对负载增加。<br>
故障转移和备份：设计故障转移机制和数据备份策略。<br>
构建前后端分离的微服务项目需要综合考虑架构设计、技术选型、开发流程、测试、部署和运维等多个方面。<br>随着技术的发展，新的工具和框架不断涌现，可以根据项目需求和团队能力灵活选择。', '学习架构', 'https://wlmtsys.com:9000/huihui/bushu3956.png');

INSERT INTO huihui.contact (id, name, email, message, created_time) VALUES (9, 'huihui', '', '你好呀', '2024-10-26 18:17:02');


INSERT INTO huihui.contactmethods (name, value, icon, id) VALUES ('Email', '3103733088@qq.com', 'icon-email', 1);
INSERT INTO huihui.contactmethods (name, value, icon, id) VALUES ('QQ', '3103733088', 'icon-qq', 2);
INSERT INTO huihui.contactmethods (name, value, icon, id) VALUES ('WeChat', 'h3103733088', 'icon-wechat', 3);
INSERT INTO huihui.contactmethods (name, value, icon, id) VALUES ('Phone', '158907661050', 'icon-phone', 4);

INSERT INTO huihui.earnedbadges (id, name, icon, url) VALUES (1, '未来媒体实验室官网', 'https://wlmtsys.com/img/logo.f40865cf.png', 'https://wlmtsys.com');
INSERT INTO huihui.earnedbadges (id, name, icon, url) VALUES (2, '代码星辰阁公众号', 'https://wlmtsys.com:9000/wlmtsys/2024/09/20/90e57bc9b0bc485ebfb09ebf3446f399.jpg', 'https://mp.weixin.qq.com/s/Roxb6knlBuUwIm4mLhvjIA');
INSERT INTO huihui.earnedbadges (id, name, icon, url) VALUES (3, 'AI Apprentice', 'https://via.placeholder.com/50x50?text=AA', 'https://developer.mozilla.org/');
INSERT INTO huihui.earnedbadges (id, name, icon, url) VALUES (4, 'Design Dynamo', 'https://via.placeholder.com/50x50?text=DD', 'https://developer.mozilla.org/');

INSERT INTO huihui.enitem_data (item_id, image, description, video, video_poster, en_id, excerpt, content, title, item_name) VALUES (1, 'https://wlmtsys.com:9000/huihui/blct.jpg', 'Action movies are packed with thrilling sequences, intense combat, and high-stakes drama. They often feature heroic protagonists facing seemingly insurmountable challenges', 'https://samplelib.com/lib/preview/mp4/sample-5s.mp4', 'https://picsum.photos/id/6/800/400', 2, 'Action movies have come a long way since their inception, evolving from practical stunts to complex CGI sequences', 'Action movies have been a staple of cinema since the early days of film. Initially relying on practical stunts and choreographed fight scenes, the genre has evolved dramatically with the advent of computer-generated imagery (CGI). Early action stars like Douglas Fairbanks and Errol Flynn set the stage with swashbuckling adventures, while later icons like Bruce Lee and Jackie Chan brought martial arts into the mainstream. The 1980s and 1990s saw the rise of muscle-bound action heroes like Arnold Schwarzenegger and Sylvester Stallone, who dominated the box office with their larger-than-life personas. As technology advanced, filmmakers began incorporating more CGI into their action sequences, allowing for even more spectacular and fantastical scenes. Modern action movies often blend practical effects with digital enhancements, creating a hybrid approach that aims to deliver the best of both worlds. While some purists argue that the overuse of CGI has diminished the impact of action scenes, others appreciate the new possibilities it opens up for storytelling and visual spectacle. As the genre continues to evolve, filmmakers are constantly pushing the boundaries of whats possible, delivering ever more thrilling and immersive experiences to audiences worldwide.', 'The Evolution of Action Movies: From Stunts to CGI', '部落冲突');

INSERT INTO huihui.entertainment (en_id, title, icon, items, description, image, article_id) VALUES (1, 'Movies', '🎬', 'Action, Comedy, Drama, Sci-Fi', 'Explore a world of cinematic wonders across various genres.', 'https://picsum.photos/id/1/800/400', null);
INSERT INTO huihui.entertainment (en_id, title, icon, items, description, image, article_id) VALUES (2, 'Games', '🎮', '部落冲突, FPS, Strategy, Puzzle', 'Immerse yourself in interactive digital experiences', 'https://wlmtsys.com:9000/huihui/blct.jpg', null);
INSERT INTO huihui.entertainment (en_id, title, icon, items, description, image, article_id) VALUES (3, 'Books', '📚', 'Fiction, Non-fiction, Mystery, Biography', 'Dive into captivating stories and enlightening knowledge.', 'https://picsum.photos/id/3/800/400', null);
INSERT INTO huihui.entertainment (en_id, title, icon, items, description, image, article_id) VALUES (4, 'TV Showsv', '📺', 'Sitcoms, Drama Series, Documentaries, Reality TV', 'Binge-watch your favorite series and discover new ones.', 'https://picsum.photos/id/4/800/400', null);

INSERT INTO huihui.experiences (ex_id, title, description, year, image, skills, challenges_overcome, key_achievements) VALUES (1, '广东白云学院', '2022年高考，来到广东白云学院，第一次接触编程，希望自己能在这段时间里学到很多。', '2022-09', 'https://wlmtsys.com:9000/huihui/广东白云学院1.jpg', '', '', '');
INSERT INTO huihui.experiences (ex_id, title, description, year, image, skills, challenges_overcome, key_achievements) VALUES (2, '郁南县西江中学', '经过3 年初中，适应了高压环境，开启了三年高中生涯', '2022-06', 'https://wlmtsys.com:9000/huihui/西江中学2.jpg', '郁南县西江中学坐落在西江河畔的郁南县城金鱼山上，占地240多亩，建筑面积21000多平方米，绿化面积8000平方米。花园式的校园绿草茵茵，空气清新怡人，环境优雅舒适。校现占地220110平方米，建筑面积60000多平方米。有教学班60个，学生3200多人，教职工235人。教学设备设施现代化，教室宽敞明亮，电脑室、语音室、实验室、电教平台一应俱全。教学区、运动区、宿舍区分区独立，各显特色，教学区和生活区有各种功能楼房24幢，运动区有各种球类场地19个和400米塑胶跑道。为帮助贫困学生完成学业和奖励成绩优秀学生，在广大校友和社会各方力量的支持下，学校筹集巨额的助学奖学基金，每年用于助学奖学的资金约40万元，使更多好学上进的学子完成其学业，圆其入读大学之梦。', '', '');
INSERT INTO huihui.experiences (ex_id, title, description, year, image, skills, challenges_overcome, key_achievements) VALUES (3, '郁南县西江中学', '小学升初中，来到西江中学，开启了长达六年的生活', '2017-09', 'https://wlmtsys.com:9000/huihui/西江中学1.jpg', '郁南县西江中学坐落在西江河畔的郁南县城金鱼山上，占地240多亩，建筑面积21000多平方米，绿化面积8000平方米。花园式的校园绿草茵茵，空气清新怡人，环境优雅舒适。校现占地220110平方米，建筑面积60000多平方米。有教学班60个，学生3200多人，教职工235人。教学设备设施现代化，教室宽敞明亮，电脑室、语音室、实验室、电教平台一应俱全。教学区、运动区、宿舍区分区独立，各显特色，教学区和生活区有各种功能楼房24幢，运动区有各种球类场地19个和400米塑胶跑道。为帮助贫困学生完成学业和奖励成绩优秀学生，在广大校友和社会各方力量的支持下，学校筹集巨额的助学奖学基金，每年用于助学奖学的资金约40万元，使更多好学上进的学子完成其学业，圆其入读大学之梦。', '', '');
INSERT INTO huihui.experiences (ex_id, title, description, year, image, skills, challenges_overcome, key_achievements) VALUES (4, '河口镇中心小学', '在小学开启了人生的住宿生活', '2015-09', 'https://wlmtsys.com:9000/huihui/河口镇中心小学.png', '河口镇中心小学是原民国27年创办的河南乡国民小学堂，1981年始定今名。
该校占地1.2万平方米，校舍建筑面积3146平方米。内设图书室、阅览室、队部室、仪器室和体育室。现有15个教学班，学生526人。教师35人，其中小学高级教师28人，一级教师7人。', '', '');


INSERT INTO huihui.learning (le_id, title, description, icon, color, progress, fulldescription, skills) VALUES (1, 'Vue', 'Vue.js是一个avaScript框架，用于构建用户界面和单页应用程序，帮助开发者以更简洁、高效的方式构建交互式的Web界面。', '📊', '#2ecc71', 50, '', 'HTML5, CSS3, JavaScript, React, Vue.js, Node.js');
INSERT INTO huihui.learning (le_id, title, description, icon, color, progress, fulldescription, skills) VALUES (2, 'JAVA', 'Java是一种广泛使用的高级编程语言，是一种面向对象的语言，这意味着它使用类和对象来组织数据和操作。', '💻', '#3498db', 75, '', 'java基础,Mysql,MyBatis-Plus,SpringBoot,SpringCloud');
INSERT INTO huihui.learning (le_id, title, description, icon, color, progress, fulldescription, skills) VALUES (3, 'AI', 'AI大模型是指具有大量参数和复杂结构的人工智能模型，通常基于深度学习技术，能够处理大量数据并学习复杂的模式和关系。', '🤖', '#e74c3c', 20, '', '');

INSERT INTO huihui.life (li_id, title, description, image) VALUES (1, 'Exploring Nature', 'Discovering the beauty of hidden trails and breathtaking landscapes', 'https://wlmtsys.com:9000/huihui/caoc.jpg');
INSERT INTO huihui.life (li_id, title, description, image) VALUES (2, 'Culinary Journey', 'Tasting exotic flavors and mastering the art of cooking', 'https://wlmtsys.com:9000/huihui/shiwu.jpg');
INSERT INTO huihui.life (li_id, title, description, image) VALUES (3, 'Cultural Experiences', 'Immersing in diverse cultures and traditions around the world.\'', 'https://wlmtsys.com:9000/huihui/gz.jpg');


INSERT INTO huihui.lifecontents (id, title, description, image, full_description, li_id) VALUES (1, '保持心脏震动', '“请保持心脏震动  因为有人等你共鸣”', 'https://wlmtsys.com:9000/huihui/1km.jpg', '        <h1>共鸣的力量：保持心灵震动</h1>
        <p>在这个快节奏的世界里，我们常常被日常生活的喧嚣和繁忙所淹没。我们奔波于工作、家庭、朋友之间，不断地追逐着目标和梦想。然而，在这一切的喧嚣中，我们偶尔会感到一种难以言说的孤独和空虚。正是在这些时刻，我们需要提醒自己：“请保持心脏震动，因为有人等你共鸣。”</p>

        <p>这句话不仅仅是一句温馨的提醒，它是一种生活的态度，一种对深层次人际关系的渴望和珍视。它告诉我们，即使在最孤独的时刻，我们也绝不是孤单一人。在我们的生活中，总有那么一些人，他们在乎我们、理解我们，愿意与我们共同经历生活的起起落落。</p>

        <blockquote>“请保持心脏震动 因为有人等你共鸣”</blockquote>

        <p>这句话提醒我们，无论生活多么艰难，总有人与我们同在。他们可能是我们的家人、朋友、爱人，甚至是我们还没有遇见的人。这些联系可能并不总是显而易见的，但它们是真实存在的，它们在等待我们去发现、去培养。</p>

        <p>共鸣不仅仅是在快乐时的分享，更是在困难时期的支持。当我们感到失落、迷茫或痛苦时，知道有人能够理解我们的感受，这种共鸣可以给我们力量，帮助我们度过难关。</p>

        <p>因此，让我们保持心灵的震动，保持对生活的热爱和希望。让我们敞开心扉，去感受那些与我们共鸣的人的温暖。因为在这个广阔的世界中，我们从来都不是孤单一人。</p>

        <p><strong>结束语：</strong>在人生的旅途中，让我们记住，每一次心灵的震动都可能与另一个灵魂产生共鸣。让我们珍惜这些联系，因为它们是我们生命中最宝贵的财富。</p>', 1);
INSERT INTO huihui.lifecontents (id, title, description, image, full_description, li_id) VALUES (2, 'Camping in Yellowstone', 'Experiencing the wonders of America\\\'s first national park.', 'https://wlmtsys.com:9000/wlmtsys/2024/09/20/90e57bc9b0bc485ebfb09ebf3446f399.jpg', 'Experience the challenge and beauty of one of America\\\'s most famous hiking trails. The Appalachian Trail stretches from Georgia to Maine, offering stunning views and unforgettable memories.', 2);
INSERT INTO huihui.lifecontents (id, title, description, image, full_description, li_id) VALUES (3, 'Scuba Diving in the Great Barrier Reef', 'Exploring the world\\\'s largest coral reef system', 'https://wlmtsys.com:9000/wlmtsys/2024/09/20/90e57bc9b0bc485ebfb09ebf3446f399.jpg', 'Experience the challenge and beauty of one of America\\\'s most famous hiking trails. The Appalachian Trail stretches from Georgia to Maine, offering stunning views and unforgettable memories.', 3);

INSERT INTO huihui.music (id, title, artist, cover, genre, is_favorite, audio) VALUES (1, '同天空', '周柏豪', 'https://wlmtsys.com:9000/huihui/baiyun.jpg', 'Popular ', 1, 'https://wlmtsys.com:9000/huihui/周柏豪 - 同天空.mp3');
INSERT INTO huihui.music (id, title, artist, cover, genre, is_favorite, audio) VALUES (2, '念风及你', '胡夏', 'https://wlmtsys.com:9000/huihui/念风及你.jpg', 'Popular ', 1, 'https://wlmtsys.com:9000/huihui/胡夏 - 念风及你.mp3');
INSERT INTO huihui.music (id, title, artist, cover, genre, is_favorite, audio) VALUES (3, '所念皆星河', 'CMJ', 'https://wlmtsys.com:9000/huihui/所念皆星河.jpg', 'Absolute ', 1, 'https://wlmtsys.com:9000/huihui/CMJ - 所念皆星河.mp3');

INSERT INTO huihui.resources (re_id, name, url, icon, le_id) VALUES (1, 'Vue2笔记', 'https://baiyunu-wlmtsys.feishu.cn/wiki/OQNiw9xUGij3AMkOfXicnXIFngf', '📊', 1);
INSERT INTO huihui.resources (re_id, name, url, icon, le_id) VALUES (2, 'Vue3笔记', 'https://baiyunu-wlmtsys.feishu.cn/wiki/OQNiw9xUGij3AMkOfXicnXIFngf', '📊', 1);
INSERT INTO huihui.resources (re_id, name, url, icon, le_id) VALUES (5, 'MyBatis-Plus', 'https://mp.weixin.qq.com/s/0ZOHNOVf4t4XeQ9kG74M5g', 'https://wlmtsys.com:9000/huihui/LIAO.png', 2);
INSERT INTO huihui.resources (re_id, name, url, icon, le_id) VALUES (6, 'Spring Boot', 'https://mp.weixin.qq.com/s/kkNl2bVAklHpfU1fOGh7KQ', 'https://wlmtsys.com:9000/huihui/下载.jpg', 2);

INSERT INTO huihui.social (id, name, url, icon) VALUES (1, 'GitHub', 'https://github.com/6Huihui6', 'icon-github');
INSERT INTO huihui.social (id, name, url, icon) VALUES (2, 'Gitee', 'https://gitee.com/huijinhui', 'icon-instagram');
INSERT INTO huihui.social (id, name, url, icon) VALUES (3, 'Twitter', 'https://via.placeholder.com/50x50?text=WW', 'icon-twitter');
INSERT INTO huihui.social (id, name, url, icon) VALUES (4, 'Twitter', 'https://via.placeholder.com/50x50?text=WW', 'icon-instagram');

INSERT INTO huihui.timeline (time_id, title, description, date) VALUES (1, '大三', '致力于成为Java开发工程师', '2024-2025');
INSERT INTO huihui.timeline (time_id, title, description, date) VALUES (2, '大二', '学习了Java基础，职业生涯开始规划', '2023-2024');
INSERT INTO huihui.timeline (time_id, title, description, date) VALUES (3, '大一', '学习了H5和cs3，感觉很有趣！', '2022-2023');
INSERT INTO huihui.timeline (time_id, title, description, date) VALUES (4, '迷茫中', '迷迷糊糊选择了计算机专业', '2022');

INSERT INTO huihui.wheelItems (image, limage, rimage, name, intro, id) VALUES ('https://wlmtsys.com:9000/huihui/1.jpg,https://wlmtsys.com:9000/huihui/2.jpg,https://wlmtsys.com:9000/huihui/3.jpg,https://wlmtsys.com:9000/huihui/4.jpg,https://wlmtsys.com:9000/huihui/5.jpg,https://wlmtsys.com:9000/huihui/6.jpg,https://wlmtsys.com:9000/huihui/7.jpg,https://wlmtsys.com:9000/huihui/8.jpg,https://wlmtsys.com:9000/huihui/9.jpg,https://wlmtsys.com:9000/huihui/10.jpg', 'https://wlmtsys.com:9000/huihui/left.jpg', 'https://wlmtsys.com:9000/huihui/right.jpg', 'WUMINGHUI', '每个人都是一颗小行星，感激我们的光锥曾经彼此重叠。', 1);

