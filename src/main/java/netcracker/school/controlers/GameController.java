package netcracker.school.controlers;

import characters.DrawableEntity;
import characters.Player;
import engine.GameThread;
import movers.MoveAction;
import net.minidev.json.JSONArray;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GameController {
    Player player;
    GameThread gameThread=GameThread.getInstance();
    @RequestMapping("/game")
    public String hello(Model model) {
        if(!gameThread.isAlive())gameThread.startGame();
        player=gameThread.getPlayer();
        model.addAttribute("hello", "Hello Player");
        if (player.isAlive()) {
            return "game";
        }else{
            if(gameThread.countCreature()==0) {
                return "game_player_win";
            }else{
                return "game_over";
            }
        }
    }

    @RequestMapping(value = "/gameland", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
    public String gameland(Model model) {
        if(!gameThread.isAlive())gameThread.startGame();
        DrawableEntity[][] map=gameThread.getSettleMap();
        JSONArray jArryMap = new JSONArray();
        for(int i=0;i<map.length;i++){
            JSONArray jArry = new JSONArray();
            for(int j=0;j<map.length;j++) {
                if(map[i][j]!=null) {
                    jArry.add(j, map[i][j].getModel());
                }else{
                    jArry.add(j, "");
                }
            }
            jArryMap.add(jArry);
        }
        model.addAttribute("land", jArryMap);
        return "jsonTemplate";
    }

    @RequestMapping(value = "/gameplayer/{action}", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
    public String gameplayer(@PathVariable("action") String action, Model model) {
        gameThread.getPlayer().setAction(MoveAction.valueOf(action));
        model.addAttribute("land", action);
        return "jsonTemplate";
    }
}