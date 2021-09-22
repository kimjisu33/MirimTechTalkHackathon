# MirimTechTalkHackathon
미림 테크톡 해커톤 / Create, Read API


#### 구현기능
- Create : 게시글 만들기
- Read : 게시글 리스트 불러오기


#### 사용언어
- JAVA
- 프레임워크 : Spring Boot
- API 클라이언트 : Postman


---
<br>
<br>

### 작성 코드 설명

* MirimTechTalkHackathon/CreateRead/src/main/java/com/example/demo/dataModel/model.java

```
public class model {
	private String title;
	private String description;
	
	...
}
```
→ 게시글(데이터) class
<br>
<br>
* MirimTechTalkHackathon/CreateRead/src/main/java/com/example/demo/controller/controller.java

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
	
	@PutMapping("/create/{id}") //데이터 추가하기
	public void putData(@PathVariable("id") String id, @RequestParam("title") String title, @RequestParam("description") String description) {
		model user=new model(title,description);	
		Map.put(id, user); 
	}
}
```


---
<br>
<br>

### 사용예시(사용방법)
Postman 사용

* Read
![readURL](https://user-images.githubusercontent.com/81640695/134329032-1b8c1180-65bb-47db-902b-fdaf18c08bdf.png)
→ /read URL 사용예시<br>
![readResult](https://user-images.githubusercontent.com/81640695/134329370-b87eab21-17c1-41c8-bed0-2a0c74716961.png)
→ /read URL 결과(기본 데이터)<br>
![readResultChrome](https://user-images.githubusercontent.com/81640695/134329411-9f567098-7700-4e4c-8ad5-e53dc193d447.PNG)
→ /read URL 사용예시(Chrome)

<br>
<br>

* Create
![createURL](https://user-images.githubusercontent.com/81640695/134329605-409abe9e-9bec-4d5c-8ab8-5ec0adabfa88.png)
→ /create URL 사용예시<br>
![afterCreate](https://user-images.githubusercontent.com/81640695/134329627-f5295504-ac98-4c63-befe-906854cca72e.png)
→ /create URL 사용결과(4 추가됨)
