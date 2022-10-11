package Simple.TheJail.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString

public class Room {
	@Id
	private int roomId;
	private String roomName;
	private String roomType;

}
