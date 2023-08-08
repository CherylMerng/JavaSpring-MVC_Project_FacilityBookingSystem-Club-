package sg.edu.iss.club;

import java.time.LocalDate;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sg.edu.iss.club.domain.Booking;
import sg.edu.iss.club.domain.Facility;
import sg.edu.iss.club.domain.Member;
import sg.edu.iss.club.repo.BookingRepository;
import sg.edu.iss.club.repo.FacilityRepository;
import sg.edu.iss.club.repo.MemberRepository;

@SpringBootApplication
public class ClubApplication {

  public static void main(String[] args) {
    SpringApplication.run(ClubApplication.class, args);
  }

  @PostConstruct
  public void init() {
    // Setting Spring Boot SetTimeZone
    TimeZone.setDefault(TimeZone.getTimeZone("SGT"));
  }
  
  @Bean
  CommandLineRunner initData(MemberRepository memberRepository,
                            FacilityRepository facilityRepository,
                            BookingRepository bookingRepository) {
    return (args) -> {
      // Add a few members
      Member einstein = memberRepository.saveAndFlush(new Member("Einstein", null, "Albert", "einstein", "password"));
      Member picasso = memberRepository.saveAndFlush(new Member("Picasso", "Pablo", "Ruiz", "picasso", "password"));
      memberRepository.saveAndFlush(new Member("Webber", "Andrew", "Lloyd", "webber", "password"));
      
      // Add a few facilities
      Facility lab = facilityRepository.saveAndFlush(new Facility("Lab", "Einstein's Experiment Area"));
      Facility studio = facilityRepository.saveAndFlush(new Facility("Studio", "Picasso's Work Place"));
      
      // Add a few bookings
      bookingRepository.saveAndFlush(new Booking(einstein, lab, LocalDate.now(), LocalDate.now().plusDays(2), "Work on fun experiments"));
      bookingRepository.saveAndFlush(new Booking(picasso, studio, LocalDate.now().plusDays(7), LocalDate.now().plusDays(10), "Draw anohter masterpiece"));
      
    };
  }

}
