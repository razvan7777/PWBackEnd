package com.example.pwbackend.Services;

import com.example.pwbackend.Models.Bodies.AppointmentBody;
import com.example.pwbackend.Models.Entities.Appointment;
import com.example.pwbackend.Repositories.AppointmentRepository;
import com.example.pwbackend.Repositories.SurgeonRepository;
import com.example.pwbackend.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<AppointmentBody> getAppointmentsBySurgeonId(Long surgeonId)
    {
        List<Appointment> appointments = appointmentRepository.findBySurgeonId(surgeonId).orElse(null);

        if (appointments == null)
            return  null;

        List<AppointmentBody> appointmentBodies = new ArrayList<>();

        appointments.forEach(appointment -> appointmentBodies.add(
                new AppointmentBody(
                        appointment.getId(),
                        appointment.getUser().getId(),
                        appointment.getSurgeon().getId(),
                        appointment.getDateStart(),
                        appointment.getDateEnd()
                )
        ));

        return appointmentBodies;
    }

    public List<AppointmentBody> getAppointmentsByUserId(Long userId)
    {
        List<Appointment> appointments = appointmentRepository.findByUserId(userId).orElse(null);

        if (appointments == null)
            return  null;

        List<AppointmentBody> appointmentBodies = new ArrayList<>();

        appointments.forEach(appointment -> appointmentBodies.add(
            new AppointmentBody(
                    appointment.getId(),
                    appointment.getUser().getId(),
                    appointment.getSurgeon().getId(),
                    appointment.getDateStart(),
                    appointment.getDateEnd()
            )
        ));

        return appointmentBodies;
    }

    public Boolean deleteAppointment(Long id)
    {
        appointmentRepository.deleteById(id);

        Appointment appointment = appointmentRepository.findById(id).orElse(null);

        return appointment == null;
    }

}
