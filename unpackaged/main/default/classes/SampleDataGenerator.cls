public with sharing class SampleDataGenerator {
    private static final List<Time> SESSION_TIMES = new List<Time>{
        Time.newInstance(9, 0, 0, 0),
        Time.newInstance(13, 30, 0, 0)
    };

    private static final Integer SESSION_BATCH_SIZE = 500;
    @TestVisible
    private static final Integer FUTURE_DAYS_COVERED = 20;
    @TestVisible
    private static final Integer PAST_DAYS_COVERED = 5;

    public static Id generateData() {
        // Remove current sessions and bookings
        delete [SELECT Id FROM Booking__c];
        delete [SELECT Id FROM Session__c];

        // Get existing contacts and experiences
        List<Contact> contacts = [SELECT Id FROM Contact];
        List<Experience__c> experiences = [
            SELECT Id, Capacity__c
            FROM Experience__c
        ];

        // Generate new sessions
        List<Session__c> sessions = generateSessions(experiences);
        insert sessions;

        // Generate bookings in batch to avoid hitting DML limits
        SampleBookingBatch sampleBooking = new SampleBookingBatch(
            experiences,
            sessions,
            contacts
        );
        Id batchProcessId = Database.executeBatch(
            sampleBooking,
            SESSION_BATCH_SIZE
        );
        return batchProcessId;
    }

    private static List<Session__c> generateSessions(
        List<Experience__c> experiences
    ) {
        List<Session__c> sessions = new List<Session__c>();
        for (Experience__c experience : experiences) {
            Date sessionDate = Date.today().addDays(0 - PAST_DAYS_COVERED);
            for (
                Integer i = 0; i < PAST_DAYS_COVERED + FUTURE_DAYS_COVERED; i++
            ) {
                sessionDate = sessionDate.addDays(1);
                for (Time sessionTime : SESSION_TIMES) {
                    Session__c session = new Session__c();
                    session.Date__c = sessionDate;
                    session.Experience__c = experience.Id;
                    session.Start_Time__c = sessionTime;
                    sessions.add(session);
                }
            }
        }
        return sessions;
    }
}