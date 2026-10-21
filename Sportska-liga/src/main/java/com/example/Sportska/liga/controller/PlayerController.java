package controller;

import data.DemoData;
import model.Team;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PlayerController {

    @GetMapping("/a")
    public String getTeams(Model model) {
        model.addAttribute("teams", DemoData.teams);
        return "listaA";
    }

    @GetMapping("/b")
    public String getPlayers(Model model) {
        model.addAttribute("players", DemoData.players);
        return "listaB";
    }
    @GetMapping("/a/action/{id}")
    public String getTeamAction(@PathVariable Long id, Model model){
        Team selectedTeam = DemoData.teams.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null)

                model.addAttribute("team",selectedTeam);
        return "action";
    }
}
