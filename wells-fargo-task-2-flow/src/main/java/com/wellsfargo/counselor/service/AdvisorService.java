package com.wellsfargo.counselor.service;

import com.wellsfargo.counselor.entity.Advisor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdvisorService {

    private List<Advisor> advisors = new ArrayList<>();

    public List<Advisor> getAllAdvisors() {
        return advisors;
    }

    public Advisor getAdvisorById(Long id) {
        return advisors.stream()
                .filter(advisor -> advisor.getAdvisorId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Advisor not found"));
    }

    public Advisor createAdvisor(Advisor advisor) {
        advisors.add(advisor);
        return advisor;
    }

    public Advisor updateAdvisor(Long id, Advisor updatedAdvisor) {
        Advisor advisor = getAdvisorById(id);
        advisor.setFirstName(updatedAdvisor.getFirstName());
        advisor.setLastName(updatedAdvisor.getLastName());
        advisor.setAddress(updatedAdvisor.getAddress());
        advisor.setPhone(updatedAdvisor.getPhone());
        advisor.setEmail(updatedAdvisor.getEmail());
        return advisor;
    }

    public void deleteAdvisor(Long id) {
        Advisor advisor = getAdvisorById(id);
        advisors.remove(advisor);
    }
}