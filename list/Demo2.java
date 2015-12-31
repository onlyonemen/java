package list;

import java.util.HashMap;
import java.util.Map;

import main.Demo;
/**
 * map
 * @author h154651
 *
 */
public class Demo2 implements Demo{

	@Override
	public void start() {
		Map<Integer, String> map =new HashMap<Integer, String>();
		map.put(1, "a");
		map.put(2, "a");
		map.put(3, "a");
		map.put(4, "a");
		for(int i=1;i<=map.size();i++){
			System.out.println(map.get(i));
		}
		
	}

}
