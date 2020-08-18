var messageApi = Vue.resource('/info{/id}');
var projecteApi = Vue.resource('/project');

Vue.component('message-form', {
    props: ['message', "selected"],
    data: function () {
        return {
            text: this.selected,
            isLoading: false
        }
    },
    template:
        '<div>' +
        '<div>' +
        '<textarea class="form-control" :disabled="isLoading" style="min-width: 700px; min-height: 400px; -webkit-box-sizing: border-box; -moz-box-sizing: border-box; box-sizing: border-box;" type="text" placeholder="Write something" v-model="text" />' +
        '<br>' +
        '<button class="btn btn-dark" :disabled="isLoading" type="button" @click="save" >' +
        '<span :class="{spiner:!isLoading}" class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>' +
        'Run' +
        '</button>' +
        '</div>' +
        '</div>',
    methods: {
        save: function () {
            this.isLoading = true;
            var msg = {text: this.text};

            messageApi.save({}, msg).then(result =>
                result.json().then(data => {
                    this.message = data;
                    this.text = ''
                }).finally(() => {
                    this.isLoading = false;
                })
            )
        }
    },
    watch: {
        selected: function (selected) {
            this.text = selected;
        }
    }

});


Vue.component('select-project-form', {
    data: function () {
        return {
            selectProject: '',
            selected: '',
            projects: []
        }
    },
    template:
        '<select v-model="selected">'+
        '<option v-for="project in projects" :key="project.id" :value="project.value">{{ project.value }}</option>' +
        '</select>',
    created: function () {
        projecteApi.get().then(result =>
            result.json().then(data =>
                data.forEach(project => this.projects.push(project))
            )
        )
    }
});

Vue.component('select-form', {
    data: function () {
        return {
            scenarios: [],
            selected: '',
            messages: []
        }
    },
    template:
        '<div style="position: relative; width: 500px;">' +
        '<message-form :messages="messages" :selected="selected"/>' +
        '<br>' +
        '<select v-model="selected">' +
        '<option disabled value="">Выберите один из вариантов</option>' +
        '<option v-for="scenario in scenarios" :key="scenario.key" :value="scenario.description">{{ scenario.summary }}</option>' +
        '</select>' +
        '<br>' +
        '<br>' +
        '<select-project-form/>'+
        '</div>',
    created: function () {
        messageApi.get().then(result =>
            result.json().then(data =>
                data.forEach(scenario => this.scenarios.push(scenario))
            )
        )
    }
});

var select = new Vue({
    el: '#select',
    template:
        '<select-form/>',
    data: {
    },

});