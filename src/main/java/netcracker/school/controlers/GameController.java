package netcracker.school.controlers;

import characters.Creature;
import characters.MobModel;
import characters.NPC;
import characters.Player;
import engine.GameLand;
import engine.GameThread;
import items.Damager;
import movers.MoveAction;
import net.minidev.json.JSONArray;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GameController {
    Player player= Player.getInstance();
    GameLand gameLand= GameLand.getInstance();
    GameThread gameThread=GameThread.getInstance();
    @RequestMapping("/game")
    public String hello(Model model) {
        if(!gameLand.isSettle())settleGame();
        //model.addAttribute("land", gameLand.settleMap());
        if(!gameThread.isAlive())gameThread.start();
        model.addAttribute("hello", "Hello Player");
        if (player.isAlive()) {
            return "game";
        }else{
            if(gameLand.countCreature()==0) {
                return "game_player_win";
            }else{
                return "game_over";
            }
        }
    }

    @RequestMapping(value = "/gameland", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
    public String gameland(Model model) {
        if(!gameLand.isSettle())settleGame();
        if(!gameLand.isSettle())settleGame();
       MobModel[][] map=gameLand.settleMap();
        JSONArray jArryMap = new JSONArray();
        for(int i=0;i<map.length;i++){
            JSONArray jArry = new JSONArray();
            for(int j=0;j<map.length;j++) {
                if(map[i][j]!=null) {
                    jArry.add(j, map[i][j].getClass().getName());
                }else{
                    jArry.add(j, "");
                }
            }

            jArryMap.add(jArry);
        }
        model.addAttribute("land", jArryMap);
        return "jsonTemplate";
    }

    @RequestMapping(value = "/gameplayer", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.POST)
    public String gameplayer(@PathVariable("action") String action, Model model) {
        player.setAction(MoveAction.valueOf(action));
        return "";
    }

    private void settleGame() {
        List<MobModel> allmobs=new ArrayList<MobModel>();
        allmobs.add(new NPC(new Damager(100,100),150));
        allmobs.add(new NPC(new Damager(100,100),150));
        allmobs.add(new NPC(new Damager(100,100),150));

        allmobs.add(new Creature(new Damager(5,10),15));
        allmobs.add(new Creature(new Damager(5,10),15));
        allmobs.add(new Creature(new Damager(5,10),15));
        allmobs.add(new Creature(new Damager(5,10),15));
        allmobs.add(new Creature(new Damager(5,10),15));

        allmobs.add(player);
        gameLand.setlle(allmobs);
    }
}