<template>
    <a v-bind:href={page}
       v-bind:class={className}
       v-on:mouseEnter="handleMouseEnter"
       v-on:mouseLeave="handleMouseLeave"
    >{{text}}</a>
</template>

<script>
    const status = {
        NORMAL: 'link-normal',
        HOVERED: 'link-hovered'
    };
    export default {
        props: ['page', 'text'],
        data() {
            return {
                className: status.NORMAL
            };
        },

        methods: {
            handleMouseEnter(){
                this.className = status.HOVERED;
            },
            handleMouseLeave(){
                this.className = status.NORMAL;
            }
        },

        created(){
            this.page = 'google.com.ar'
        }
    }
</script>