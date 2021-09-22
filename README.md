# MirimTechTalkHackathon
미림 테크톡 해커톤 / Create, Read API


##### 구현기능
- Create : 게시글 만들기
- Read : 게시글 리스트 불러오기


##### 사용언어
- JAVA
- 프레임워크 : Spring Boot
- API 클라이언트 : Postman

---


#### 작성 코드 설명

* MirimTechTalkHackathon/CreateRead/src/main/java/com/example/demo/dataModel/model.java

```
public class model {
	private String title;
	private String description;
	
	...
}
```
→ 게시글(데이터) class


MirimTechTalkHackathon/CreateRead/src/main/java/com/example/demo/controller/controller.java

```
@RestController
public class controller {
private Map<String, model> Map;
	
	@PostConstruct
	public void init() { //기본 데이터
		Map=new HashMap<String, model>();
		Map.put("1", new model("제목1", "내용1"));
		Map.put("2", new model("제목2", "내용2"));
		Map.put("3", new model("제목3", "내용3"));
	}
	
	@GetMapping("/read") //전체 읽어오기
	public List<model> getDataList(){
		return new ArrayList<model>(Map.values());
	}
	
	@PutMapping("/create/{id}")
	public void putData(@PathVariable("id") String id, @RequestParam("title") String title, @RequestParam("description") String description) {
		model user=new model(title,description);	
		Map.put(id, user); 
	}
}
```
