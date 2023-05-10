package com.example.pwbackend.Services;

import com.example.pwbackend.Models.Bodies.AppointmentBody;
import com.example.pwbackend.Models.Entities.Appointment;
import com.example.pwbackend.Repositories.AppointmentRepository;
import com.example.pwbackend.Repositories.SurgeonRepository;
import com.example.pwbackend.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SurgeonRepository surgeonRepository;

    public AppointmentBody addAppointment(AppointmentBody appointmentBody)
    {
        Appointment appointment = new Appointment();

        appointment.setId(appointmentBody.getId());
        appointment.setUser(userRepository.findById(appointmentBody.getUserId()).orElse(null));
        appointment.setSurgeon(surgeonRepository.findById(appointmentBody.getSurgeonId()).orElse(null));
        appointment.setdateStart(appointmentBody.getDateStart());
        appointment.setDateEnd(appointmentBody.getDateEnd());

        if ( appointment.getUser() == null || appointment.getSurgeon() == null)
        {
            return null;
        }

        Appointment appointmentSaved = appointmentRepository.save(appointment);

        return new AppointmentBody(
            appointmentSaved.getId(),
            appointmentSaved.getUser().getId(),
            appointmentSaved.getSurgeon().getId(),
            appointmentSaved.getDateStart(),
            appointmentSaved.getDateEnd()
        );
    }

    public AppointmentBody getAppointment(Long id)
    {
        Appointment appointment = appointmentRepository.findById(id).orElse(null);

        if (appointment == null)
            return  null;

        return new AppointmentBody(
                appointment.getId(),
                appointment.getUser().getId(),
                appointment.getSurgeon().getId(),
                appointment.getDateStart(),
                appointment.getDateEnd()
        );
    }

    public Boolean deleteAppointment(Long id)
    {
        appointmentRepository.deleteById(id);

        Appointment appointment = appointmentRepository.findById(id).orElse(null);

        return appointment == null;
    }

}
